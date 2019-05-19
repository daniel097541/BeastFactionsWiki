package com.beastsoftware.beastfactions.factions.event;

import com.beastsoftware.beastfactions.factions.entity.IFPlayer;
import org.bukkit.Chunk;

public class FPlayerChangedOfChunkEvent extends FPlayerAbstractEvent {


    private Chunk from;
    private Chunk to;

    public FPlayerChangedOfChunkEvent(IFPlayer fPlayer, Chunk from, Chunk to) {
        super(fPlayer);
        this.from = from;
        this.to = to;
    }


    public Chunk getFrom() {
        return from;
    }

    public Chunk getTo() {
        return to;
    }
}
