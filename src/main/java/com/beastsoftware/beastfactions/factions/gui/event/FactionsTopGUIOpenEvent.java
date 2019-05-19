package com.beastsoftware.beastfactions.factions.gui.event;

import com.beastsoftware.beastfactions.factions.entity.IFPlayer;
import com.beastsoftware.beastfactions.factions.gui.struct.GUIType;

public class FactionsTopGUIOpenEvent extends GUIOpenEvent {


    public FactionsTopGUIOpenEvent(IFPlayer fPlayer, int page) {
        super(fPlayer, GUIType.TOP_GUI, page);
    }
}
