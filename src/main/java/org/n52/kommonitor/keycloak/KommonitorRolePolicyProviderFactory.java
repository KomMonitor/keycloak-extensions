package org.n52.kommonitor.keycloak;


import org.keycloak.authorization.AuthorizationProvider;
import org.keycloak.authorization.policy.provider.PolicyProvider;
import org.keycloak.authorization.policy.provider.role.RolePolicyProviderFactory;
import org.keycloak.models.KeycloakSession;

/**
 * @author <a href="mailto:psilva@redhat.com">Pedro Igor</a>
 */
public class KommonitorRolePolicyProviderFactory extends RolePolicyProviderFactory {

    private KommonitorRolePolicyProvider provider = new KommonitorRolePolicyProvider(this::toRepresentation);

    @Override
    public PolicyProvider create(AuthorizationProvider authorization) {
        return provider;
    }

    @Override
    public PolicyProvider create(KeycloakSession session) {
        return provider;
    }

    @Override
    public int order() {
        return 52;
    }

}