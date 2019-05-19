package com.beastsoftware.beastfactions.factions.gui.event;

import com.beastsoftware.beastfactions.factions.entity.IFPlayer;
import com.beastsoftware.beastfactions.factions.entity.IFaction;
import com.beastsoftware.beastfactions.factions.gui.struct.GUIType;

public class FactionPlayerManageGUIOpenEvent extends PermissionsGUIOpenEvent {
    public FactionPlayerManageGUIOpenEvent(IFPlayer fPlayer, GUIType type, int page, IFaction faction, IFPlayer target) {
        super(fPlayer, type, page, faction, target);
    }
}
