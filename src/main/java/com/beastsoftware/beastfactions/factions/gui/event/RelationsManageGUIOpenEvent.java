package com.beastsoftware.beastfactions.factions.gui.event;

import com.beastsoftware.beastfactions.factions.entity.IFPlayer;
import com.beastsoftware.beastfactions.factions.entity.IFaction;
import com.beastsoftware.beastfactions.factions.gui.struct.GUIType;

public class RelationsManageGUIOpenEvent extends PermissionsGUIOpenEvent {

    public RelationsManageGUIOpenEvent(IFPlayer fPlayer, int page, IFaction faction, Object target) {
        super(fPlayer, GUIType.RELATIONS_PERMISSIONS_MANAGE_GUI, page, faction, target);
    }
}
