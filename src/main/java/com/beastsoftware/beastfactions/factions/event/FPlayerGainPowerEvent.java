package com.beastsoftware.beastfactions.factions.event;

import com.beastsoftware.beastfactions.factions.entity.IFPlayer;

public class FPlayerGainPowerEvent extends FPlayerAbstractEvent {
    public FPlayerGainPowerEvent(IFPlayer fPlayer) {
        super(fPlayer);
    }
}
