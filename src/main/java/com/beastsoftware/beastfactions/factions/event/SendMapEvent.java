package com.beastsoftware.beastfactions.factions.event;

import com.beastsoftware.beastfactions.factions.entity.IFPlayer;

public class SendMapEvent extends FPlayerAbstractEvent {

    private int size;

    public SendMapEvent(IFPlayer fPlayer, int size) {
        super(fPlayer);
        this.size = size;
    }

    public int getSize() {
        return size;
    }
}
