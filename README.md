# Kommonitor Keycloak Extensions

Repository containing extensions/custom implementations for use with Keycloak in the Kommonitor Project. Currently implemented functionality:

### `km-mapper.js` 

Custom Tokenmapper replacing the default KC `roles` Mapper. Adds `roles` claim to Token containing all roles that:

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

### k8s

TBD