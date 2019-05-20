package info.beastsoftware.beastfactions.factions.event;

import info.beastsoftware.beastfactions.factions.entity.IFChunk;
import info.beastsoftware.beastfactions.factions.entity.IFPlayer;
import info.beastsoftware.beastfactions.factions.entity.IFaction;

import java.util.List;

public class WorldEditClaimEvent extends FPlayerAbstractEvent {

    private final IFaction faction;
    private final List<IFChunk> chunks;


    public WorldEditClaimEvent(IFPlayer fPlayer, IFaction faction, List<IFChunk> chunks) {
        super(fPlayer);
        this.faction = faction;
        this.chunks = chunks;
    }


    public IFaction getFaction() {
        return faction;
    }

    public List<IFChunk> getChunks() {
        return chunks;
    }
}
