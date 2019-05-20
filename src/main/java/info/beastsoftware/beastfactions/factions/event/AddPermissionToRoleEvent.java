package info.beastsoftware.beastfactions.factions.event;

import info.beastsoftware.beastfactions.factions.entity.IFaction;
import info.beastsoftware.beastfactions.factions.entity.IFactionRole;
import info.beastsoftware.beastfactions.factions.entity.IPermission;

public class AddPermissionToRoleEvent extends RolePermissionEvent {

    public AddPermissionToRoleEvent(IFaction faction, IPermission permission, IFactionRole role) {
        super(faction, permission, role);
    }
}
