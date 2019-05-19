package com.beastsoftware.beastfactions.factions.event;

import com.beastsoftware.beastfactions.factions.entity.IFPlayer;
import com.beastsoftware.beastfactions.factions.entity.IPermission;

public class AddPermissionToPlayerEvent extends PlayerPermissionEvent {
    public AddPermissionToPlayerEvent(IFPlayer fPlayer, IPermission permission) {
        super(fPlayer, permission);
    }
}
