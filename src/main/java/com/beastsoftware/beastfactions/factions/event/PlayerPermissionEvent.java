package com.beastsoftware.beastfactions.factions.event;

import com.beastsoftware.beastfactions.factions.entity.IFPlayer;
import com.beastsoftware.beastfactions.factions.entity.IPermission;

public abstract class PlayerPermissionEvent extends FPlayerAbstractEvent {

    private final IPermission permission;


    public PlayerPermissionEvent(IFPlayer fPlayer, IPermission permission) {
        super(fPlayer);
        this.permission = permission;
    }


    public IPermission getPermission() {
        return permission;
    }
}
