package info.beastsoftware.beastfactions.factions.gui.event;

import info.beastsoftware.beastfactions.factions.entity.IFPlayer;
import info.beastsoftware.beastfactions.factions.entity.IFaction;
import info.beastsoftware.beastfactions.factions.gui.struct.GUIType;

public class RolesPermissionsGUIOpenEvent extends PermissionsGUIOpenEvent {

    public RolesPermissionsGUIOpenEvent(IFPlayer fPlayer, IFaction faction) {
        super(fPlayer, GUIType.ROLES_PERMISSIONS_PAGE, faction, null);
    }

    public RolesPermissionsGUIOpenEvent(IFPlayer fPlayer, int page, IFaction faction) {
        super(fPlayer, GUIType.ROLES_PERMISSIONS_PAGE, page, faction, null);
    }
}
