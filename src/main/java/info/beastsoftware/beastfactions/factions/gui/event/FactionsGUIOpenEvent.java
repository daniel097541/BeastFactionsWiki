package info.beastsoftware.beastfactions.factions.gui.event;

import info.beastsoftware.beastfactions.factions.entity.IFPlayer;
import info.beastsoftware.beastfactions.factions.entity.IFaction;
import info.beastsoftware.beastfactions.factions.gui.struct.GUIType;

public class FactionsGUIOpenEvent extends GUIOpenEvent {

    private final IFaction faction;
    private final Object target;

    public FactionsGUIOpenEvent(IFPlayer fPlayer, GUIType type, IFaction faction, Object target) {
        super(fPlayer, type);
        this.faction = faction;
        this.target = target;
    }

    public FactionsGUIOpenEvent(IFPlayer fPlayer, GUIType type, int page, IFaction faction, Object target) {
        super(fPlayer, type, page);
        this.faction = faction;
        this.target = target;
    }

    public Object getTarget() {
        return target;
    }

    public IFaction getFaction() {
        return faction;
    }
}
