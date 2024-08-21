var ArrayList = Java.type('java.util.ArrayList');
var HashSet = Java.type('java.util.HashSet');
var RoleUtils = Java.type('org.keycloak.models.utils.RoleUtils');
var forEach = Array.prototype.forEach;

var realmRoles = new ArrayList();
var realmRoleSet = new HashSet();

//Role directly assigned
forEach.call(RoleUtils.expandCompositeRolesStream(user.getRealmRoleMappingsStream()).toArray(), function (roleModel) {
    realmRoleSet.add(roleModel.getName());
});


// Role assigned via direct membership in groups
forEach.call(user.getGroupsStream().toArray(), function (groupModel) {
    forEach.call(RoleUtils.expandCompositeRolesStream(groupModel.getRoleMappingsStream()).toArray(), function (roleModel) {
        // All roles this group has
        realmRoleSet.add(roleModel.getName());
    });
});

token.getOtherClaims().put('realm_access', {'roles': realmRoleSet});
