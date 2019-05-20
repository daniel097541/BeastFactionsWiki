package info.beastsoftware.beastfactions.factions.gui.event;

import info.beastsoftware.beastfactions.factions.entity.IFPlayer;
import info.beastsoftware.beastfactions.factions.entity.IFaction;
import info.beastsoftware.beastfactions.factions.gui.struct.GUIType;

public class RelationsListGUIOpenEvent extends PermissionsGUIOpenEvent {

    public RelationsListGUIOpenEvent(IFPlayer fPlayer, int page, IFaction faction) {
        super(fPlayer, GUIType.RELATIONS_PERMISSIONS_PAGE, page, faction, null);
    }
}
