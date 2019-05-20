package info.beastsoftware.beastfactions.factions.event;

import info.beastsoftware.beastfactions.factions.entity.IFChunk;
import info.beastsoftware.beastfactions.factions.entity.IFaction;

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
