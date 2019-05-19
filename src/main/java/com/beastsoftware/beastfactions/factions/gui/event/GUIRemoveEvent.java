package com.beastsoftware.beastfactions.factions.gui.event;

import com.beastsoftware.beastfactions.factions.entity.IFaction;
import com.beastsoftware.beastfactions.factions.event.VoidEvent;
import com.beastsoftware.beastfactions.factions.gui.entity.gui.IFactionsGUI;
import com.beastsoftware.beastfactions.factions.gui.struct.GUIType;

public class GUIRemoveEvent extends VoidEvent {

    private final IFactionsGUI gui;

    public GUIRemoveEvent(IFactionsGUI gui) {
        this.gui = gui;
    }


    public IFactionsGUI getGui() {
        return gui;
    }


    public IFaction getFaction() {
        return gui.getFaction();
    }

    public GUIType getGuiType() {
        return gui.getGuiType();
    }
}
