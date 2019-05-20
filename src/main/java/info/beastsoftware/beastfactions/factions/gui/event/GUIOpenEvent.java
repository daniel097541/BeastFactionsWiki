package info.beastsoftware.beastfactions.factions.gui.event;

import info.beastsoftware.beastfactions.factions.entity.IFPlayer;
import info.beastsoftware.beastfactions.factions.entity.IFaction;
import info.beastsoftware.beastfactions.factions.event.FPlayerAbstractEvent;
import info.beastsoftware.beastfactions.factions.gui.struct.GUIType;

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
