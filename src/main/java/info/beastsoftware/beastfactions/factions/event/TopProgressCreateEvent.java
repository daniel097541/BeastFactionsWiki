package info.beastsoftware.beastfactions.factions.event;

import info.beastsoftware.beastfactions.factions.entity.IFaction;
import info.beastsoftware.beastfactions.factions.entity.ITopCollSnapshot;

import java.util.List;

public class TopProgressCreateEvent extends SimpleFactionEvent {

    private final List<ITopCollSnapshot> collSnapshots;

    public TopProgressCreateEvent(IFaction faction, List<ITopCollSnapshot> collSnapshots) {
        super(faction);
        this.collSnapshots = collSnapshots;
    }

    public List<ITopCollSnapshot> getCollSnapshots() {
        return collSnapshots;
    }
}
