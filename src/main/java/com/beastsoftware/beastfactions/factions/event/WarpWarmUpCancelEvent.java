package com.beastsoftware.beastfactions.factions.event;

import com.beastsoftware.beastfactions.factions.entity.IFPlayer;
import com.beastsoftware.beastfactions.factions.entity.IFactionWarp;

public class WarpWarmUpCancelEvent extends WarmUpRemoveEvent {

    private IFactionWarp warp;

    public WarpWarmUpCancelEvent(IFPlayer fPlayer, IFactionWarp warp) {
        super(fPlayer);
        this.warp = warp;
    }

    public IFactionWarp getWarp() {
        return warp;
    }
}
