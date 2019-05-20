package info.beastsoftware.beastfactions.factions.gui.event;

import info.beastsoftware.beastfactions.factions.entity.IFPlayer;
import info.beastsoftware.beastfactions.factions.entity.IFaction;
import info.beastsoftware.beastfactions.factions.gui.struct.GUIType;

public class FactionPlayerManageGUIOpenEvent extends PermissionsGUIOpenEvent {
    public FactionPlayerManageGUIOpenEvent(IFPlayer fPlayer, GUIType type, int page, IFaction faction, IFPlayer target) {
        super(fPlayer, type, page, faction, target);
    }
}
