package com.beastsoftware.beastfactions.factions.event;

import com.beastsoftware.beastfactions.factions.entity.IFPlayer;
import com.beastsoftware.beastfactions.factions.entity.IFaction;

public class UnclaimAllEvent extends SimpleFactionEvent {
    private IFPlayer fPlayer;

    public UnclaimAllEvent(IFaction faction, IFPlayer fPlayer) {
        super(faction);
        this.fPlayer = fPlayer;
    }

    public UnclaimAllEvent(IFaction faction) {
        super(faction);
    }

    public IFPlayer getfPlayer() {
        return fPlayer;
    }
}
