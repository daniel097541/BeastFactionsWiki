package com.beastsoftware.beastfactions.factions.event;

import com.beastsoftware.beastfactions.factions.entity.IFPlayer;

public class DisbandConfirmationToggleEvent extends FPlayerAbstractEvent {
    public DisbandConfirmationToggleEvent(IFPlayer fPlayer) {
        super(fPlayer);
    }
}
