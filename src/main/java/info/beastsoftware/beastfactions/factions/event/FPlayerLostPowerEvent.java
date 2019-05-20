package info.beastsoftware.beastfactions.factions.event;

import info.beastsoftware.beastfactions.factions.entity.IFPlayer;

public class FPlayerLostPowerEvent extends FPlayerAbstractEvent {
    public FPlayerLostPowerEvent(IFPlayer fPlayer) {
        super(fPlayer);
    }
}
