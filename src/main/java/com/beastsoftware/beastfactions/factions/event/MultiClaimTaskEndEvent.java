package com.beastsoftware.beastfactions.factions.event;

import com.beastsoftware.beastfactions.factions.entity.IFPlayer;
import com.beastsoftware.beastfactions.factions.entity.IFaction;

public class MultiClaimTaskEndEvent extends MultiLandTaskEndEvent {


    public MultiClaimTaskEndEvent(int claimed, IFPlayer player, IFaction faction) {
        super(claimed, player, faction);
    }
}
