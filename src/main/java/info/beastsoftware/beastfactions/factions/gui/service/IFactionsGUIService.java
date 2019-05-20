package info.beastsoftware.beastfactions.factions.gui.service;

import info.beastsoftware.beastfactions.factions.entity.IFaction;
import info.beastsoftware.beastfactions.factions.gui.entity.button.IButton;
import info.beastsoftware.beastfactions.factions.gui.entity.gui.IFactionsGUI;
import info.beastsoftware.beastfactions.factions.gui.entity.page.IPage;
import info.beastsoftware.beastfactions.factions.gui.struct.GUIType;
import gnu.trove.map.TLongObjectMap;
import org.bukkit.inventory.Inventory;

import java.util.HashMap;
import java.util.List;


public interface IFactionsGUIService<T> {


    TLongObjectMap<HashMap<GUIType, List<IFactionsGUI>>> getAll();

    IFactionsGUI getGuiOfType(IFaction faction, GUIType type, T target);

    GUIType getType(IFaction faction, Inventory inventory);

    HashMap<GUIType, List<IFactionsGUI>> getAllOfFaction(IFaction faction);

    void reloadGUI(GUIType guiType, IFaction faction, T target);

    boolean isLoaded(GUIType guiType, IFaction faction, T target);

    IFactionsGUI getGuiFromInventory(IFaction faction, Inventory inventory);

    void realTimeUpdateButton(IButton button, IFactionsGUI gui, T target, IPage page, GUIType type, IFaction faction);

    void removeGUI(IFaction faction, IFactionsGUI gui);

}
