package info.beastsoftware.beastfactions.factions.event;

import info.beastsoftware.beastfactions.factions.entity.IFPlayer;

public class DisbandConfirmationToggleEvent extends FPlayerAbstractEvent {
    public DisbandConfirmationToggleEvent(IFPlayer fPlayer) {
        super(fPlayer);
    }
}
