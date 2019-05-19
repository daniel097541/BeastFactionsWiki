package com.beastsoftware.beastfactions.factions.event;

import com.beastsoftware.beastfactions.factions.entity.ITopEntityColl;

public class TopEntityCollSaveEvent extends TopEntityCollEvent{
    public TopEntityCollSaveEvent(ITopEntityColl topEntityColl) {
        super(topEntityColl);
    }
}
