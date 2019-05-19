package com.beastsoftware.beastfactions.factions.gui.event;

import com.beastsoftware.beastfactions.factions.entity.IFPlayer;
import com.beastsoftware.beastfactions.factions.gui.struct.GUIType;

public class WarpsGUIOpenEvent extends GUIOpenEvent {
    public WarpsGUIOpenEvent(IFPlayer fPlayer, int page) {
        super(fPlayer, GUIType.WARPS_GUI, page);
    }
}
