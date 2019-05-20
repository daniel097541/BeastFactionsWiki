package info.beastsoftware.beastfactions.factions.gui.event;

import info.beastsoftware.beastfactions.factions.entity.IFPlayer;
import info.beastsoftware.beastfactions.factions.entity.IFaction;
import info.beastsoftware.beastfactions.factions.gui.struct.GUIType;

public class PlayersPermissionsGUIOpenEvent extends PermissionsGUIOpenEvent {

    public PlayersPermissionsGUIOpenEvent(IFPlayer fPlayer, int page, IFaction faction) {
        super(fPlayer, GUIType.PLAYERS_LIST_PAGE, page, faction, null);
    }
}
