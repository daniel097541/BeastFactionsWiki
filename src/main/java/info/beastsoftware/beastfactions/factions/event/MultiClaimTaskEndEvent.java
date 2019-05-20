package info.beastsoftware.beastfactions.factions.event;

import info.beastsoftware.beastfactions.factions.entity.IFPlayer;
import info.beastsoftware.beastfactions.factions.entity.IFaction;

public class MultiClaimTaskEndEvent extends MultiLandTaskEndEvent {


    public MultiClaimTaskEndEvent(int claimed, IFPlayer player, IFaction faction) {
        super(claimed, player, faction);
    }
}
