package info.beastsoftware.beastfactions.factions.event;

import info.beastsoftware.beastfactions.factions.entity.IFPlayer;
import info.beastsoftware.beastfactions.factions.entity.IFaction;
import org.bukkit.Chunk;

public class MultiLandEvent extends LandEvent {

    private final int radius;

    private final IFaction faction;

    public MultiLandEvent(IFPlayer fPlayer, Chunk chunk, int radius, IFaction faction) {
        super(fPlayer, chunk);
        this.radius = radius;
        this.faction = faction;
    }

    public int getRadius() {
        return radius;
    }

    @Override
    public IFaction getFaction() {
        return faction;
    }
}
