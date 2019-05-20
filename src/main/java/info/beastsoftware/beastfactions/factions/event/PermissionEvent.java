package info.beastsoftware.beastfactions.factions.event;

import info.beastsoftware.beastfactions.factions.entity.IFaction;
import info.beastsoftware.beastfactions.factions.entity.IPermission;

public abstract class PermissionEvent extends SimpleFactionEvent {

    private final IPermission permission;

    public PermissionEvent(IFaction faction, IPermission permission) {
        super(faction);
        this.permission = permission;
    }


    public IPermission getPermission() {
        return permission;
    }
}
