package info.beastsoftware.beastfactions.factions.event;

import info.beastsoftware.beastfactions.factions.entity.IFPlayer;

public class ToggleAutoClaimEvent extends FPlayerAbstractEvent {
    public ToggleAutoClaimEvent(IFPlayer fPlayer) {
        super(fPlayer);
    }
}
