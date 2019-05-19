package com.beastsoftware.beastfactions.factions.event;

import com.beastsoftware.beastfactions.factions.entity.IFPlayer;
import com.beastsoftware.beastfactions.factions.entity.IFaction;
import org.bukkit.Chunk;
import org.bukkit.ChunkSnapshot;

public abstract class LandEvent extends FPlayerAbstractEvent {
    private Chunk chunk;

    public LandEvent(IFPlayer fPlayer, Chunk chunk) {
        super(fPlayer);
        this.chunk = chunk;
    }

    public ChunkSnapshot getChunkSnapshot() {
        return chunk.getChunkSnapshot();
    }

    public IFaction getFaction(){
        return getfPlayer().getFaction();
    }

    public Chunk getChunk() {
        return chunk;
    }
}
