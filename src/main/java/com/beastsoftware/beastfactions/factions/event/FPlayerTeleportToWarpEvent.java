package com.beastsoftware.beastfactions.factions.event;


import com.beastsoftware.beastfactions.factions.entity.IFPlayer;
import com.beastsoftware.beastfactions.factions.entity.IFactionWarp;

public class FPlayerTeleportToWarpEvent extends FPlayerAbstractEvent {
    private IFactionWarp warp;


    public FPlayerTeleportToWarpEvent(IFPlayer fPlayer, IFactionWarp warp) {
        super(fPlayer);
        this.warp = warp;
    }

    public IFactionWarp getWarp() {
        return warp;
    }
}
