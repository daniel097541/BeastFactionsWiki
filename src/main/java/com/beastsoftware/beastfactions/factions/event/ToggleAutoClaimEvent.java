package com.beastsoftware.beastfactions.factions.event;

import com.beastsoftware.beastfactions.factions.entity.IFPlayer;

public class ToggleAutoClaimEvent extends FPlayerAbstractEvent {
    public ToggleAutoClaimEvent(IFPlayer fPlayer) {
        super(fPlayer);
    }
}
