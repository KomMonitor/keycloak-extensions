# Pin base image version
ARG KC_IMAGE_VERSION="26.6.4"
# Digest of quay.io/keycloak/keycloak:26.6.3
ARG KC_IMAGE_DIGEST="sha256:0aae0de7fca85525f727d3354df17896092de8bb26ae4c12d89c77e5df8cbce4"
# Keycloak features compiled into every DB target.
ARG KC_FEATURES="admin-fine-grained-authz:v1,scripts,token-exchange:v1"

# Compile custom provider JAR
FROM maven:3-eclipse-temurin-17-alpine@sha256:22ab50236eec4106ef19d86c0268c0adfac6a2051a3f5d473a315a3ab77c619f AS mvnbuilder
WORKDIR /build

# Resolve and cache dependencies
COPY pom.xml .
RUN mvn -B -ntp dependency:go-offline

# Then compile the sources
COPY src src
RUN mvn -B -ntp package

# Shared prep: add the provider and enable build-time endpoints, reused by every
# DB target so the layer is built once
FROM quay.io/keycloak/keycloak:${KC_IMAGE_VERSION}@${KC_IMAGE_DIGEST} AS kc-base
COPY --from=mvnbuilder --chown=1000:0 /build/target/keycloak-extensions-1.0.jar /opt/keycloak/providers/keycloak-extensions-1.0.jar
# Enable endpoints for health checks and metrics (build-time options)
ENV KC_HEALTH_ENABLED=true \
    KC_METRICS_ENABLED=true

# Final Keycloak image with PostgreSQL support.
FROM kc-base AS postgres
ARG KC_IMAGE_VERSION
ARG KC_FEATURES
ENV KC_DB=postgres
RUN /opt/keycloak/bin/kc.sh build --features="${KC_FEATURES}"

# Set OCI metadata
LABEL org.opencontainers.image.title="KomMonitor Keycloak (PostgreSQL)" \
      org.opencontainers.image.description="Keycloak with KomMonitor role-policy SPI and role mapper, optimized for PostgreSQL" \
      org.opencontainers.image.source="https://github.com/kommonitor/keycloak-extensions" \
      org.opencontainers.image.vendor="52°North" \
      org.opencontainers.image.licenses="Apache-2.0" \
      org.opencontainers.image.version="${KC_IMAGE_VERSION}"

# Run as unprivileged user
USER 1000

# Expose HTTP, HTTPS and management (health/metrics) ports
EXPOSE 8080 8443 9000
ENTRYPOINT ["/opt/keycloak/bin/kc.sh", "start", "--optimized"]

# Final Keycloak image with MSSQL DB support
FROM kc-base AS mssql
ARG KC_IMAGE_VERSION
ARG KC_FEATURES
ENV KC_DB=mssql
RUN /opt/keycloak/bin/kc.sh build --features="${KC_FEATURES}"

LABEL org.opencontainers.image.title="KomMonitor Keycloak (MSSQL)" \
      org.opencontainers.image.description="Keycloak with KomMonitor role-policy SPI and role mapper, optimized for MSSQL" \
      org.opencontainers.image.source="https://github.com/kommonitor/keycloak-extensions" \
      org.opencontainers.image.vendor="52°North" \
      org.opencontainers.image.licenses="Apache-2.0" \
      org.opencontainers.image.version="${KC_IMAGE_VERSION}"

# Run as unprivileged user
USER 1000

# Expose HTTP, HTTPS and management (health/metrics) ports
EXPOSE 8080 8443 9000
ENTRYPOINT ["/opt/keycloak/bin/kc.sh", "start", "--optimized"]
