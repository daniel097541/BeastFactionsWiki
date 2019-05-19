package com.beastsoftware.beastfactions.factions.gui.event;

import com.beastsoftware.beastfactions.factions.entity.IFPlayer;
import com.beastsoftware.beastfactions.factions.entity.IFaction;
import com.beastsoftware.beastfactions.factions.gui.struct.GUIType;

public class PlayersPermissionsGUIOpenEvent extends PermissionsGUIOpenEvent {

    public PlayersPermissionsGUIOpenEvent(IFPlayer fPlayer, int page, IFaction faction) {
        super(fPlayer, GUIType.PLAYERS_LIST_PAGE, page, faction, null);
    }
}
