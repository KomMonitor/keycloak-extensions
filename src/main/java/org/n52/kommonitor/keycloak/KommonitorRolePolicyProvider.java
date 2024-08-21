package org.n52.kommonitor.keycloak;


import java.util.Set;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

import org.jboss.logging.Logger;
import org.keycloak.authorization.AuthorizationProvider;
import org.keycloak.authorization.identity.Identity;
import org.keycloak.authorization.model.Policy;
import org.keycloak.authorization.policy.evaluation.Evaluation;
import org.keycloak.authorization.policy.provider.PolicyProvider;
import org.keycloak.authorization.policy.provider.role.RolePolicyProvider;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.RealmModel;
import org.keycloak.models.UserModel;
import org.keycloak.models.UserProvider;
import org.keycloak.representations.idm.authorization.RolePolicyRepresentation;

public class KommonitorRolePolicyProvider implements PolicyProvider {

    private final BiFunction<Policy, AuthorizationProvider, RolePolicyRepresentation> representationFunction;

    private static final Logger logger = Logger.getLogger(RolePolicyProvider.class);

    public KommonitorRolePolicyProvider(BiFunction<Policy, AuthorizationProvider, RolePolicyRepresentation> representationFunction) {
        this.representationFunction = representationFunction;
    }

    @Override
    public void evaluate(Evaluation evaluation) {
        Policy policy = evaluation.getPolicy();
        RolePolicyRepresentation policyRep = representationFunction.apply(policy, evaluation.getAuthorizationProvider());
        Set<String> allowed_roles = policyRep.getRoles().stream().map(RolePolicyRepresentation.RoleDefinition::getId).collect(Collectors.toSet());
        AuthorizationProvider authorizationProvider = evaluation.getAuthorizationProvider();
        RealmModel realm = authorizationProvider.getKeycloakSession().getContext().getRealm();
        Identity identity = evaluation.getContext().getIdentity();

        KeycloakSession session = authorizationProvider.getKeycloakSession();
        UserProvider users = session.users();
        UserModel user = users.getUserById(realm, identity.getId());

        if (user.getRoleMappingsStream().anyMatch(r -> allowed_roles.contains(r.getId()))) {
            logger.debug("GRANTED --> user.hasDirectRole");
            evaluation.grant();
            return;
        }

//        if (logger.isDebugEnabled()) {
//            logger.debug("USER IS MEMBER OF GROUPS: " + user.getGroupsStream().map(GroupModel::getName).collect(Collectors.joining(", ")));
//        }

        // iterate real user groups and success-fast
        user.getGroupsStream().anyMatch(g -> g.getRoleMappingsStream().anyMatch(role -> {
            if (allowed_roles.contains(role.getId())) {
                logger.debugf("GRANTED --> user.hasRoleFromGroup %s", g.getName());
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
