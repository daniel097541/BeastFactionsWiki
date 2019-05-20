package info.beastsoftware.beastfactions.factions.gui.action;

import info.beastsoftware.beastfactions.factions.entity.IFaction;

public abstract class FactionsAction extends Action {

    protected final IFaction faction;

    public FactionsAction(IFaction faction, boolean dynamic) {
        super(dynamic);
        this.faction = faction;
    }

}
