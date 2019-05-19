package com.beastsoftware.beastfactions.factions.event;

import com.beastsoftware.beastfactions.factions.entity.IFaction;

public class FactionsRemoveTnTFromBankEvent extends FactionsTnTEvent {
    public FactionsRemoveTnTFromBankEvent(IFaction faction, long amount) {
        super(faction, amount);
    }
}
