package info.beastsoftware.beastfactions.factions.event;

import info.beastsoftware.beastfactions.factions.entity.IFaction;

public class ClaimCollCreationEvent extends SimpleFactionEvent {
    public ClaimCollCreationEvent(IFaction faction) {
        super(faction);
    }
}
