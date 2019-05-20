package info.beastsoftware.beastfactions.factions.event;

import info.beastsoftware.beastfactions.factions.entity.IFaction;

public class WarnFactionEvent extends SimpleFactionEvent {
    public WarnFactionEvent(IFaction faction) {
        super(faction);
    }
}
