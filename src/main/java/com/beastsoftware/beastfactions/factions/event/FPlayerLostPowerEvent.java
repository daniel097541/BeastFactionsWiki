package com.beastsoftware.beastfactions.factions.event;

import com.beastsoftware.beastfactions.factions.entity.IFPlayer;

public class FPlayerLostPowerEvent extends FPlayerAbstractEvent {
    public FPlayerLostPowerEvent(IFPlayer fPlayer) {
        super(fPlayer);
    }
}
