package info.beastsoftware.beastfactions.factions.event;

import info.beastsoftware.beastfactions.factions.entity.ITopEntityColl;

public class TopEntityCollSaveEvent extends TopEntityCollEvent{
    public TopEntityCollSaveEvent(ITopEntityColl topEntityColl) {
        super(topEntityColl);
    }
}
