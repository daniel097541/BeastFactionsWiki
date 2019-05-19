package com.beastsoftware.beastfactions.factions.event;

import com.beastsoftware.beastfactions.factions.entity.IFaction;

public class FactionsAddTnTToBankEvent extends FactionsTnTEvent {
    public FactionsAddTnTToBankEvent(IFaction faction, long amount) {
        super(faction, amount);
    }
}
