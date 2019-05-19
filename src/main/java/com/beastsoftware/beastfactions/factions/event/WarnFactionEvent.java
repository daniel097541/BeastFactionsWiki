package com.beastsoftware.beastfactions.factions.event;

import com.beastsoftware.beastfactions.factions.entity.IFaction;

public class WarnFactionEvent extends SimpleFactionEvent {
    public WarnFactionEvent(IFaction faction) {
        super(faction);
    }
}
