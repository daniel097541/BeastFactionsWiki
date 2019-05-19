package com.beastsoftware.beastfactions.factions.gui.event;

import com.beastsoftware.beastfactions.factions.entity.IFPlayer;
import com.beastsoftware.beastfactions.factions.entity.IFaction;
import com.beastsoftware.beastfactions.factions.gui.struct.GUIType;

public abstract class PermissionsGUIOpenEvent extends FactionsGUIOpenEvent {


    public PermissionsGUIOpenEvent(IFPlayer fPlayer, GUIType type, IFaction faction, Object target) {
        super(fPlayer, type, faction, target);
    }

    public PermissionsGUIOpenEvent(IFPlayer fPlayer, GUIType type, int page, IFaction faction, Object target) {
        super(fPlayer, type, page, faction, target);
    }
}
