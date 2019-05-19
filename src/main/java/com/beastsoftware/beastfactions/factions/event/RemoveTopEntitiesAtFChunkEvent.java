package com.beastsoftware.beastfactions.factions.event;

import com.beastsoftware.beastfactions.factions.entity.IFChunk;
import com.beastsoftware.beastfactions.factions.entity.IFaction;

public class RemoveTopEntitiesAtFChunkEvent extends SimpleFactionEvent {

    private final IFChunk chunk;

    public RemoveTopEntitiesAtFChunkEvent(IFaction faction, IFChunk chunk) {
        super(faction);
        this.chunk = chunk;
    }

    public IFChunk getChunk() {
        return chunk;
    }
}
