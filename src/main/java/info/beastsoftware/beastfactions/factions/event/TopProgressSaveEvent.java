package info.beastsoftware.beastfactions.factions.event;

import info.beastsoftware.beastfactions.factions.entity.IFaction;
import info.beastsoftware.beastfactions.factions.entity.IFactionTopProgress;

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
