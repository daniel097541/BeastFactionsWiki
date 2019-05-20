package info.beastsoftware.beastfactions.factions.event;

import info.beastsoftware.beastfactions.factions.entity.IFChunk;
import info.beastsoftware.beastfactions.factions.entity.IFaction;

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
