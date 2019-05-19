package com.beastsoftware.beastfactions.factions.event;

import com.beastsoftware.beastfactions.factions.entity.IFaction;

public abstract class FactionsTnTEvent extends SimpleFactionEvent {

    private final long amount;

    public FactionsTnTEvent(IFaction faction, long amount) {
        super(faction);
        this.amount = amount;
    }


    public long getAmount() {
        return amount;
    }
}
