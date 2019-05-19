package com.beastsoftware.beastfactions.factions.gui.entity.gui;

import com.beastsoftware.beastfactions.factions.entity.IFaction;

public interface IFactionsGUI<T> extends IGUI {
    IFaction getFaction();

    T getTarget();

}
