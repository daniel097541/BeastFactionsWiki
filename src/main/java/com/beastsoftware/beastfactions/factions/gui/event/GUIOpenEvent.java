package com.beastsoftware.beastfactions.factions.gui.event;

import com.beastsoftware.beastfactions.factions.entity.IFPlayer;
import com.beastsoftware.beastfactions.factions.entity.IFaction;
import com.beastsoftware.beastfactions.factions.event.FPlayerAbstractEvent;
import com.beastsoftware.beastfactions.factions.gui.struct.GUIType;

public abstract class GUIOpenEvent extends FPlayerAbstractEvent {

    private final GUIType type;
    private int page;

    public GUIOpenEvent(IFPlayer fPlayer, GUIType type) {
        super(fPlayer);
        this.type = type;
        this.page = 0;
    }

    public GUIOpenEvent(IFPlayer fPlayer, GUIType type, int page) {
        super(fPlayer);
        this.type = type;
        this.page = page;
    }

    public GUIType getType() {
        return type;
    }

    public int getPage() {
        return page;
    }

    public IFaction getFaction() {
        return getfPlayer().getFaction();
    }
}
