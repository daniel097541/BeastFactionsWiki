package com.beastsoftware.beastfactions.factions.event;

import com.beastsoftware.beastfactions.factions.entity.IFChunk;
import com.beastsoftware.beastfactions.factions.entity.IFaction;

public class RemoveClaimAtFChunkEvent extends SimpleFactionEvent {

    private final IFChunk chunk;

    public RemoveClaimAtFChunkEvent(IFaction faction, IFChunk chunk) {
        super(faction);
        this.chunk = chunk;
    }


    public IFChunk getFChunk() {
        return chunk;
    }
}
