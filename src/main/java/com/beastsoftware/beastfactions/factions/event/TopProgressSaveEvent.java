package com.beastsoftware.beastfactions.factions.event;

import com.beastsoftware.beastfactions.factions.entity.IFaction;
import com.beastsoftware.beastfactions.factions.entity.IFactionTopProgress;
import com.beastsoftware.beastfactions.factions.entity.impl.FactionTopProgress;

public class TopProgressSaveEvent extends SimpleFactionEvent {

    private final IFactionTopProgress factionTopProgress;

    public TopProgressSaveEvent(IFaction faction, IFactionTopProgress factionTopProgress) {
        super(faction);
        this.factionTopProgress = factionTopProgress;
    }

    public IFactionTopProgress getFactionTopProgress() {
        return factionTopProgress;
    }
}
