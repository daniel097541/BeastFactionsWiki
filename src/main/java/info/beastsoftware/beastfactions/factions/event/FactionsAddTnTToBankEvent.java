package info.beastsoftware.beastfactions.factions.event;

import info.beastsoftware.beastfactions.factions.entity.IFaction;

public class FactionsAddTnTToBankEvent extends FactionsTnTEvent {
    public FactionsAddTnTToBankEvent(IFaction faction, long amount) {
        super(faction, amount);
    }
}
