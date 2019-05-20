package info.beastsoftware.beastfactions.factions.event;

import info.beastsoftware.beastfactions.factions.entity.IFPlayer;
import info.beastsoftware.beastfactions.factions.entity.IPermission;

public class RemovePermissionFromPlayerEvent extends PlayerPermissionEvent {
    public RemovePermissionFromPlayerEvent(IFPlayer fPlayer, IPermission permission) {
        super(fPlayer, permission);
    }
}
