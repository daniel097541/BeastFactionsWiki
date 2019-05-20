package info.beastsoftware.beastfactions.factions.event;

import info.beastsoftware.beastfactions.factions.entity.IFPlayer;
import info.beastsoftware.beastfactions.factions.entity.IFaction;
import org.bukkit.Chunk;
import org.bukkit.ChunkSnapshot;

public class ClaimEvent extends LandEvent {

    private Chunk chunk;
    private IFaction faction;

    public ClaimEvent(IFPlayer fPlayer, Chunk chunk, IFaction faction) {
        super(fPlayer, chunk);
        this.chunk = chunk;
        this.faction = faction;
    }

    public Chunk getChunk() {
        return chunk;
    }

    @Override
    public IFaction getFaction() {
        return faction;
    }

    public ChunkSnapshot getChunkSnapshot() {
        return chunk.getChunkSnapshot();
    }
}
