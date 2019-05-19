package com.beastsoftware.beastfactions.factions.event;

import com.beastsoftware.beastfactions.factions.entity.IFaction;

public class ClaimCollCreationEvent extends SimpleFactionEvent {
    public ClaimCollCreationEvent(IFaction faction) {
        super(faction);
    }
}
