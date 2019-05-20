package info.beastsoftware.beastfactions.factions.event;

import info.beastsoftware.beastfactions.factions.entity.IFaction;
import info.beastsoftware.beastfactions.factions.entity.IFactionRole;
import info.beastsoftware.beastfactions.factions.entity.IPermission;

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
