package info.beastsoftware.beastfactions.factions.event;

import info.beastsoftware.beastfactions.factions.entity.IFPlayer;

public class ToggleAdminBypassEvent extends FPlayerAbstractEvent {

    public ToggleAdminBypassEvent(IFPlayer fPlayer) {
        super(fPlayer);
    }
}
