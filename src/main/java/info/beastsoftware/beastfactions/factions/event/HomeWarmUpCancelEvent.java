package info.beastsoftware.beastfactions.factions.event;

import info.beastsoftware.beastfactions.factions.entity.IFPlayer;

public class HomeWarmUpCancelEvent extends WarmUpRemoveEvent {

    public HomeWarmUpCancelEvent(IFPlayer fPlayer) {
        super(fPlayer);
    }
}
