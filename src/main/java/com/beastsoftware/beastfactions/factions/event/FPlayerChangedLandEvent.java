package com.beastsoftware.beastfactions.factions.event;

import com.beastsoftware.beastfactions.factions.entity.IFPlayer;
import com.beastsoftware.beastfactions.factions.entity.IFaction;

public class FPlayerChangedLandEvent extends FPlayerAbstractEvent {


    private final IFaction from;
    private final IFaction to;


    public FPlayerChangedLandEvent(IFPlayer fPlayer, IFaction from, IFaction to) {
        super(fPlayer);
        this.from = from;
        this.to = to;
    }


    public IFaction getFrom() {
        return from;
    }

    public IFaction getTo() {
        return to;
    }
}
