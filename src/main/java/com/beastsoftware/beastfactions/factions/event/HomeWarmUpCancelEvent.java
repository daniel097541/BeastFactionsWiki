package com.beastsoftware.beastfactions.factions.event;

import com.beastsoftware.beastfactions.factions.entity.IFPlayer;

public class HomeWarmUpCancelEvent extends WarmUpRemoveEvent {

    public HomeWarmUpCancelEvent(IFPlayer fPlayer) {
        super(fPlayer);
    }
}
