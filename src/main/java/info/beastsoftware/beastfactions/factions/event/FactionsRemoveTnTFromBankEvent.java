package info.beastsoftware.beastfactions.factions.event;

import info.beastsoftware.beastfactions.factions.entity.IFaction;

public class FactionsRemoveTnTFromBankEvent extends FactionsTnTEvent {
    public FactionsRemoveTnTFromBankEvent(IFaction faction, long amount) {
        super(faction, amount);
    }
}
