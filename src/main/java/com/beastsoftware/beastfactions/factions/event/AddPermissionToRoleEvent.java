package com.beastsoftware.beastfactions.factions.event;

import com.beastsoftware.beastfactions.factions.entity.IFaction;
import com.beastsoftware.beastfactions.factions.entity.IFactionRole;
import com.beastsoftware.beastfactions.factions.entity.IPermission;

public class AddPermissionToRoleEvent extends RolePermissionEvent {

    public AddPermissionToRoleEvent(IFaction faction, IPermission permission, IFactionRole role) {
        super(faction, permission, role);
    }
}
