package info.beastsoftware.beastfactions.factions.gui.event;

import info.beastsoftware.beastfactions.factions.entity.IFPlayer;
import info.beastsoftware.beastfactions.factions.gui.struct.GUIType;

public class WarpsGUIOpenEvent extends GUIOpenEvent {
    public WarpsGUIOpenEvent(IFPlayer fPlayer, int page) {
        super(fPlayer, GUIType.WARPS_GUI, page);
    }
}
