package com.beastsoftware.beastfactions.factions.gui.event;

import com.beastsoftware.beastfactions.factions.entity.IFPlayer;
import com.beastsoftware.beastfactions.factions.entity.IFaction;
import com.beastsoftware.beastfactions.factions.gui.struct.GUIType;

public class RolesPermissionsGUIOpenEvent extends PermissionsGUIOpenEvent {

    public RolesPermissionsGUIOpenEvent(IFPlayer fPlayer, IFaction faction) {
        super(fPlayer, GUIType.ROLES_PERMISSIONS_PAGE, faction, null);
    }

    public RolesPermissionsGUIOpenEvent(IFPlayer fPlayer, int page, IFaction faction) {
        super(fPlayer, GUIType.ROLES_PERMISSIONS_PAGE, page, faction, null);
    }
}
