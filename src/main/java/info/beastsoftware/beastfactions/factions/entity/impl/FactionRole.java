package info.beastsoftware.beastfactions.factions.entity.impl;

import info.beastsoftware.beastfactions.factions.entity.IFactionRole;
import info.beastsoftware.beastfactions.factions.entity.IPermission;
import info.beastsoftware.beastfactions.factions.entity.IPermissionsColl;

import java.util.List;

public class FactionRole implements IFactionRole {

    private String roleName;
    private String displayName;
    private IPermissionsColl permissions;
    private boolean defaultRole;
    private int priority;

    public FactionRole(String roleName, String displayName, List<IPermission> permissions, boolean defaultRole, int priority) {
        this.roleName = roleName;
        this.displayName = displayName;
        this.permissions = new PermissionsColl(permissions);
        this.defaultRole = defaultRole;
        this.priority = priority;
    }

    @Override
    public String getRoleName() {
        return roleName;
    }

    @Override
    public List<IPermission> getPermissions() {
        return permissions.getPermissions();
    }

    @Override
    public boolean hasPermission(IPermission permission) {
        return permissions.contains(permission);
    }

    @Override
    public void addRolePermission(IPermission permission) {
        permissions.add(permission);
    }

    @Override
    public void removeRolePermission(IPermission permission) {
        permissions.remove(permission);
    }

    @Override
    public String getDisplayName() {
        return displayName;
    }

    @Override
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public void setName(String roleName) {
        this.roleName = roleName;
    }

    public boolean isDefaultRole() {
        return defaultRole;
    }

    @Override
    public int getPriority() {
        return priority;
    }

    @Override
    public void setPriority(int priority) {
        this.priority = priority;
    }
}
