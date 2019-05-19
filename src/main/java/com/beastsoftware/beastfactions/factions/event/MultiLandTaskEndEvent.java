package com.beastsoftware.beastfactions.factions.event;

import com.beastsoftware.beastfactions.factions.entity.IFPlayer;
import com.beastsoftware.beastfactions.factions.entity.IFaction;

public class MultiLandTaskEndEvent extends VoidEvent {
    private final int claimed;
    private final IFPlayer player;
    private final IFaction faction;

    public MultiLandTaskEndEvent(int claimed, IFPlayer player, IFaction faction) {
        this.claimed = claimed;
        this.player = player;
        this.faction = faction;
    }


    public int getClaimed() {
        return claimed;
    }

    public IFPlayer getPlayer() {
        return player;
    }

    public IFaction getFaction() {
        return faction;
    }
}
