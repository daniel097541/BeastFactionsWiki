package info.beastsoftware.beastfactions.factions.gui.event;

import info.beastsoftware.beastfactions.factions.entity.IFPlayer;
import info.beastsoftware.beastfactions.factions.entity.IFaction;
import info.beastsoftware.beastfactions.factions.gui.struct.GUIType;

public class MainPermissionsGuiOpenEvent extends PermissionsGUIOpenEvent {


    public MainPermissionsGuiOpenEvent(IFPlayer fPlayer, IFaction faction) {
        super(fPlayer, GUIType.MAIN_PERMISSIONS_PAGE, faction, null);
    }


}
