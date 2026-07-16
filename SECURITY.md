# Security

This document describes how the `kommonitor/keycloak` image is hardened at build time
and the controls an **operator must apply at run time**.

> Scope: this repository controls the **image** and its **build/publish
> pipeline**. Host, network, orchestration and organizational requirements
> remain the operator's responsibility and are listed as pointers below.

## What the image and pipeline already provide

| Control | Where |
|---------|-------|
| Base images pinned to immutable `@sha256` digests | [Dockerfile](Dockerfile) |
| Official, identifiable sources (quay.io/keycloak, Docker Hub library/maven) | [Dockerfile](Dockerfile) |
| Runs as non-root user `1000:0`, files `--chown`ed | [Dockerfile](Dockerfile) |
| Health & metrics endpoints compiled in (`/health/ready` etc. on port 9000) | [Dockerfile](Dockerfile) |
| One service per container (Keycloak only) | [Dockerfile](Dockerfile) |
| `--optimized` start (no build/write at runtime) | [Dockerfile](Dockerfile) |
| OCI metadata labels (title/source/version/…) | [Dockerfile](Dockerfile) + CI |
| No secrets in image/build context; minimal context via `.dockerignore` | [.dockerignore](.dockerignore) |
| Vulnerability scanning (Trivy, SARIF → Security tab) | [CI workflows](.github/workflows/) |
| SBOM + build provenance attestations | [CI workflows](.github/workflows/) |
| Keyless image signing (cosign) | [CI workflows](.github/workflows/) |
| Actions pinned to commit SHAs; Dependabot for images/actions/deps | [CI](.github/workflows/) + [dependabot.yml](.github/dependabot.yml) |

## What the operator must configure at run time

The image ships secure defaults but cannot enforce host-level isolation. Run the container
with at least the following:

```yaml
services:
  keycloak:
    image: kommonitor/keycloak:<version>-postgres
    user: "1000:0"
    read_only: true
    tmpfs:
      - /tmp
      - /opt/keycloak/data
    cap_drop: [ ALL ]
    security_opt:
      - no-new-privileges:true
    deploy:
      resources:
        limits:
          cpus: "2"
          memory: 2g
          pids: 2048
    healthcheck:
      test: ["CMD", "bash", "-c", "exec 3<>/dev/tcp/localhost/9000 && echo -e 'GET /health/ready HTTP/1.1\\r\\nHost: localhost\\r\\nConnection: close\\r\\n\\r\\n' >&3 && grep -q '\"status\": \"UP\"' <&3"]
      interval: 30s
      timeout: 5s
      retries: 5
    # secrets/DB/TLS/hostname env as above
```

### Preparing Keycloak for production

The above docker-compose snippet does not cover all aspects for running Keycloak for production.
Also take into account the documentation on how to set up Keycloak for production: 
https://www.keycloak.org/server/configuration-production

### Production-ready template

As a starting point, you may use the production-ready template from our
Docker repository: https://github.com/KomMonitor/docker/tree/master/prod/keycloak

### Verify image signature

Verify the signature before deploying:
  ```bash
  cosign verify kommonitor/keycloak:<tag> \
    --certificate-identity-regexp '^https://github.com/kommonitor/keycloak-extensions/' \
    --certificate-oidc-issuer https://token.actions.githubusercontent.com
  ```

### Further notes

- The Keycloak image is based on **Red Hat UBI9-micro**: minimal, with **no
  package manager and no curl/wget**
- It **does include bash** (the `kc.sh` entrypoint is a bash script)
- A curl-based Dockerfile `HEALTHCHECK` won't work (no curl), but the bash
  `/dev/tcp` probe above does. 
- Under an orchestrator, prefer a native HTTP readiness probe against `http://<host>:9000/health/ready`. Keep port
  9000 internal-only.
- Keep container **logs on stdout/stderr** so the host collects them via the
  logging driver; never write logs to files inside the container.

## Remaining responsibilities

These requirements are **out of scope for this image** and must be
covered by the operator's platform and processes:

- Segment host-admin, container-admin and access networks; restrict to necessary communication.
- No admin remote access *from* the container to the host; administer via the container runtime only.
- MAC enforcement at the host - AppArmor/SELinux profiles restricting network, filesystem and syscalls; restrict container egress.
- Forensic snapshots of container state.
- Runtime behaviour monitoring/IDS.
- Redundancy at host/orchestration level.
- Host pinning and hypervisor isolation.
- Organizational processes; the Keycloak config that is versioned in KomMonitor deployment repos covers A20.
