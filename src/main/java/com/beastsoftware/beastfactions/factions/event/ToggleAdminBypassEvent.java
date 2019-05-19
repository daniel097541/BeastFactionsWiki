package com.beastsoftware.beastfactions.factions.event;

import com.beastsoftware.beastfactions.factions.entity.IFPlayer;

public class ToggleAdminBypassEvent extends FPlayerAbstractEvent {

    public ToggleAdminBypassEvent(IFPlayer fPlayer) {
        super(fPlayer);
    }
}
