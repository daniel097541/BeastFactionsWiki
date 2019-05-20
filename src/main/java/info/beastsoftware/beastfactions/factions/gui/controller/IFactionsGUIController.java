package info.beastsoftware.beastfactions.factions.gui.controller;

import info.beastsoftware.beastfactions.factions.entity.IFPlayer;
import info.beastsoftware.beastfactions.factions.entity.IFaction;
import info.beastsoftware.beastfactions.factions.gui.event.GUIOpenEvent;
import info.beastsoftware.beastfactions.factions.gui.struct.GUIType;
import org.bukkit.event.Listener;

public interface IFactionsGUIController extends Listener {

    void register();

    void openGUI(IFPlayer player, IFaction faction, GUIType type, int page, Object target);

    void callOpenGUI(GUIOpenEvent event, Object target);
}
