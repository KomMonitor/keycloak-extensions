package org.n52.kommonitor.keycloak;


import java.util.Arrays;
import java.util.Optional;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

import org.jboss.logging.Logger;
import org.keycloak.authorization.AuthorizationProvider;
import org.keycloak.authorization.identity.Identity;
import org.keycloak.authorization.model.Policy;
import org.keycloak.authorization.policy.evaluation.Evaluation;
import org.keycloak.authorization.policy.provider.role.RolePolicyProvider;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.RealmModel;
import org.keycloak.models.UserModel;
import org.keycloak.models.UserProvider;
import org.keycloak.quarkus.runtime.configuration.Configuration;
import org.keycloak.representations.idm.authorization.RolePolicyRepresentation;


public class KommonitorRolePolicyProvider extends RolePolicyProvider {

    private static final String KOMMONITOR_REALM_KEY = "kommonitor.realms";


    private static final Logger LOG = Logger.getLogger(RolePolicyProvider.class);

    private final BiFunction<Policy, AuthorizationProvider, RolePolicyRepresentation> representationFunction;

    public KommonitorRolePolicyProvider(BiFunction<Policy, AuthorizationProvider, RolePolicyRepresentation> representationFunction) {
        super(representationFunction);
        this.representationFunction = representationFunction;
    }

    @Override
    public void evaluate(Evaluation evaluation) {
        AuthorizationProvider authorizationProvider = evaluation.getAuthorizationProvider();
        RealmModel realm = authorizationProvider.getKeycloakSession().getContext().getRealm();
        String [] kommonitorRealms = null;

        Optional<String> kommonitorRealmsOpt = Configuration.getOptionalValue(KOMMONITOR_REALM_KEY);
        if(kommonitorRealmsOpt.isPresent()) {
            kommonitorRealms = kommonitorRealmsOpt.get().split(",");
        }

        if(kommonitorRealms != null && Arrays.stream(kommonitorRealms).anyMatch(r -> r.equals(realm.getName()))) {
            LOG.debugf("KomMonitor dedicated policy evaluation for realm '%s'.", realm.getName());
            internalEvaluation(evaluation);
        } else {
            LOG.debugf("Default policy evaluation for realm '%s'.", realm.getName());
            super.evaluate(evaluation);

        }
    }

    private void internalEvaluation(Evaluation evaluation) {
        Policy policy = evaluation.getPolicy();
        RolePolicyRepresentation policyRep = this.representationFunction.apply(policy, evaluation.getAuthorizationProvider());

        Set<String> allowed_roles = policyRep.getRoles().stream().map(RolePolicyRepresentation.RoleDefinition::getId).collect(Collectors.toSet());
        AuthorizationProvider authorizationProvider = evaluation.getAuthorizationProvider();
        RealmModel realm = authorizationProvider.getKeycloakSession().getContext().getRealm();
        Identity identity = evaluation.getContext().getIdentity();

        KeycloakSession session = authorizationProvider.getKeycloakSession();
        UserProvider users = session.users();
        UserModel user = users.getUserById(realm, identity.getId());

        if (user.getRoleMappingsStream().anyMatch(r -> allowed_roles.contains(r.getId()))) {
            LOG.debug("GRANTED --> user.hasDirectRole");
            evaluation.grant();
            return;
        }

//        if (logger.isDebugEnabled()) {
//            logger.debug("USER IS MEMBER OF GROUPS: " + user.getGroupsStream().map(GroupModel::getName).collect(Collectors.joining(", ")));
//        }

        // iterate real user groups and success-fast
        user.getGroupsStream().anyMatch(g -> g.getRoleMappingsStream().anyMatch(role -> {
            if (allowed_roles.contains(role.getId())) {
                LOG.debugf("GRANTED --> user.hasRoleFromGroup %s", g.getName());
                evaluation.grant();
                return true;
            }
            return false;
        }));

//        // iterate real user groups
//        user.getGroupsStream().forEach(g -> {
//            // only iterate directly set roles
//            g.getRoleMappingsStream().forEach(roleModel -> {
//                        if (allowed_roles.contains(roleModel.getId())) {
//                            logger.debugf("GRANTED --> user.hasRoleFromGroup %s", g.getName());
//                            evaluation.grant();
//                        }
//                    }
//
//            );
//        });
        evaluation.denyIfNoEffect();
    }

    @Override
    public void close() {

    }
}
