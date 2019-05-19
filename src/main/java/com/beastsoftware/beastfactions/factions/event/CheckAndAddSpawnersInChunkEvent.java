package com.beastsoftware.beastfactions.factions.event;

import com.beastsoftware.beastfactions.factions.entity.IFaction;
import org.bukkit.Chunk;

public class CheckAndAddSpawnersInChunkEvent extends SimpleFactionEvent {

    private final Chunk chunk;

    public CheckAndAddSpawnersInChunkEvent(IFaction faction, Chunk chunk) {
        super(faction);
        this.chunk = chunk;
    }

    public Chunk getChunk() {
        return chunk;
    }
}
