package info.beastsoftware.beastfactions.factions.gui.event;

import info.beastsoftware.beastfactions.factions.entity.IFaction;
import info.beastsoftware.beastfactions.factions.event.VoidEvent;
import info.beastsoftware.beastfactions.factions.gui.entity.gui.IFactionsGUI;
import info.beastsoftware.beastfactions.factions.gui.struct.GUIType;

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
