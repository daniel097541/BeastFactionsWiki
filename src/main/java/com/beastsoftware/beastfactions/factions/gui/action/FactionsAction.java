package com.beastsoftware.beastfactions.factions.gui.action;

import com.beastsoftware.beastfactions.factions.entity.IFaction;

public abstract class FactionsAction extends Action {

    protected final IFaction faction;

    public FactionsAction(IFaction faction, boolean dynamic) {
        super(dynamic);
        this.faction = faction;
    }

}
