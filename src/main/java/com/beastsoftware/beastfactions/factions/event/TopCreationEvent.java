package com.beastsoftware.beastfactions.factions.event;

import com.beastsoftware.beastfactions.factions.entity.IFaction;

public class TopCreationEvent extends SimpleFactionEvent {
    public TopCreationEvent(IFaction faction) {
        super(faction);
    }
}
