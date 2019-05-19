package com.beastsoftware.beastfactions.factions.entity;

import java.util.List;

public interface IFactionRole {

    String getRoleName();

    List<IPermission> getPermissions();

    boolean hasPermission(IPermission permission);

    void addRolePermission(IPermission permission);

    void removeRolePermission(IPermission permission);

    String getDisplayName();

    void setDisplayName(String displayName);

    void setName(String name);

    boolean isDefaultRole();

    int getPriority();

    void setPriority(int priority);
}
