package info.beastsoftware.beastfactions.factions.gui.event;

import info.beastsoftware.beastfactions.factions.entity.IFPlayer;
import info.beastsoftware.beastfactions.factions.entity.IFaction;
import info.beastsoftware.beastfactions.factions.gui.entity.button.IButton;
import info.beastsoftware.beastfactions.factions.gui.entity.gui.IGUI;
import info.beastsoftware.beastfactions.factions.gui.entity.page.IPage;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class RolesPermissionsGUIClickedEvent extends FactionsGUIClickedEvent {
    public RolesPermissionsGUIClickedEvent(IFPlayer fPlayer, IGUI clickedGui, Inventory clickedInventory, IPage clickedPage, ItemStack clickedItem, IButton clickedButton, IFaction faction) {
        super(fPlayer, clickedGui, clickedInventory, clickedPage, clickedItem, clickedButton, faction);
    }
}
