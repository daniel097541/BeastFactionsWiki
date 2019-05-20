package info.beastsoftware.beastfactions.factions.gui.event;

import info.beastsoftware.beastfactions.factions.entity.IFPlayer;
import info.beastsoftware.beastfactions.factions.entity.IFaction;
import info.beastsoftware.beastfactions.factions.entity.IFactionRole;
import info.beastsoftware.beastfactions.factions.gui.struct.GUIType;

public class FactionRoleManageGUIOpenEvent extends PermissionsGUIOpenEvent {
    public FactionRoleManageGUIOpenEvent(IFPlayer fPlayer, GUIType type, int page, IFaction faction, IFactionRole target) {
        super(fPlayer, type, page, faction, target);
    }
}
