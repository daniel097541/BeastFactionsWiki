package info.beastsoftware.beastfactions.factions.gui.event;

import info.beastsoftware.beastfactions.factions.entity.IFPlayer;
import info.beastsoftware.beastfactions.factions.entity.IFaction;
import info.beastsoftware.beastfactions.factions.gui.struct.GUIType;

public abstract class PermissionsGUIOpenEvent extends FactionsGUIOpenEvent {


    public PermissionsGUIOpenEvent(IFPlayer fPlayer, GUIType type, IFaction faction, Object target) {
        super(fPlayer, type, faction, target);
    }

    public PermissionsGUIOpenEvent(IFPlayer fPlayer, GUIType type, int page, IFaction faction, Object target) {
        super(fPlayer, type, page, faction, target);
    }
}
