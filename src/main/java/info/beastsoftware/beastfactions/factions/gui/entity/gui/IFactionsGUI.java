package info.beastsoftware.beastfactions.factions.gui.entity.gui;

import info.beastsoftware.beastfactions.factions.entity.IFaction;

public interface IFactionsGUI<T> extends IGUI {
    IFaction getFaction();

    T getTarget();

}
