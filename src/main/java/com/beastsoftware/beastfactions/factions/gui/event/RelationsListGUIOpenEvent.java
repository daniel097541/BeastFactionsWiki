package com.beastsoftware.beastfactions.factions.gui.event;

import com.beastsoftware.beastfactions.factions.entity.IFPlayer;
import com.beastsoftware.beastfactions.factions.entity.IFaction;
import com.beastsoftware.beastfactions.factions.gui.struct.GUIType;

public class RelationsListGUIOpenEvent extends PermissionsGUIOpenEvent {

    public RelationsListGUIOpenEvent(IFPlayer fPlayer, int page, IFaction faction) {
        super(fPlayer, GUIType.RELATIONS_PERMISSIONS_PAGE, page, faction, null);
    }
}
