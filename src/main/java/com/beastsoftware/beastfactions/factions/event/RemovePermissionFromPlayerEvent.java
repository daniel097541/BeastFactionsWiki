package com.beastsoftware.beastfactions.factions.event;

import com.beastsoftware.beastfactions.factions.entity.IFPlayer;
import com.beastsoftware.beastfactions.factions.entity.IPermission;

public class RemovePermissionFromPlayerEvent extends PlayerPermissionEvent {
    public RemovePermissionFromPlayerEvent(IFPlayer fPlayer, IPermission permission) {
        super(fPlayer, permission);
    }
}
