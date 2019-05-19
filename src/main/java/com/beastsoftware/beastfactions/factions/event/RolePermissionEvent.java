package com.beastsoftware.beastfactions.factions.event;

import com.beastsoftware.beastfactions.factions.entity.IFaction;
import com.beastsoftware.beastfactions.factions.entity.IFactionRole;
import com.beastsoftware.beastfactions.factions.entity.IPermission;

public abstract class RolePermissionEvent extends PermissionEvent {

    private final IFactionRole role;


    public RolePermissionEvent(IFaction faction, IPermission permission, IFactionRole role) {
        super(faction, permission);
        this.role = role;
    }


    public IFactionRole getRole() {
        return role;
    }
}
