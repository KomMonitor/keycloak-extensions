# KomMonitor Keycloak Extensions

Repository containing extensions/custom implementations for use with Keycloak in the KomMonitor Project.
The repository also ships a security hardened Keycloak image, that bundles the extensions and .

## Extensions
Currently implemented functionality:

### `km-mapper.js` 

Custom token mapper replacing the default KC `roles` Mapper. Adds `roles` claim to Token containing all roles that:

- Are directly assigned to the User
- Are assigned to a group the user is directly part of

Note: this explicitly excludes roles that are inherited by Group/Subgroup relations.

### `KommonitorRolePolicyProvider`

Custom PolicyProvider overriding default `RolePolicyProvider`. Validates to true if user has role via:

- Role is directly assigned to the User
- Role is assigned to a group the user is directly part of

Note: this explicitly excludes roles that are inherited by Group/Subgroup relations.

## Usage

Provide the compiled `.jar` to keycloak on startup in the `/opt/keycloak/providers/` directory.

### Docker-compose
You can provide the jar via a simple file mount: 

```
    volumes:
      - ./target/keycloak-extensions-1.0-SNAPSHOT.jar:/opt/keycloak/providers/keycloak-extensions-1.0-SNAPSHOT.jar
```

Note: This file is not reloaded at runtime, for changes to take effect Keycloak needs to be restarted.

## Security
The resulting Keycloak image is hardened by taking into account common security best practices. In particular,
several baseline protection recommendations for containerized applications are taken into account. Read more
about it in the [SECURITY doc](./SECURITY.md).

