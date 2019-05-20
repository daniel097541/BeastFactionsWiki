package info.beastsoftware.beastfactions.factions.event;

import info.beastsoftware.beastfactions.factions.entity.IFPlayer;
import info.beastsoftware.beastfactions.factions.entity.IFactionWarp;

public class WarpWarmUpEndEvent extends WarmUpRemoveEvent {
    private IFactionWarp warp;

    public WarpWarmUpEndEvent(IFPlayer fPlayer, IFactionWarp warp) {
        super(fPlayer);
        this.warp = warp;
    }

    public IFactionWarp getWarp() {
        return warp;
    }
}
