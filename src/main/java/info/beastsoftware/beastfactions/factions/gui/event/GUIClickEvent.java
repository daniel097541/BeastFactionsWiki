package info.beastsoftware.beastfactions.factions.gui.event;

import info.beastsoftware.beastfactions.factions.entity.IFPlayer;
import info.beastsoftware.beastfactions.factions.event.FPlayerAbstractEvent;
import info.beastsoftware.beastfactions.factions.gui.entity.button.IButton;
import info.beastsoftware.beastfactions.factions.gui.entity.gui.IGUI;
import info.beastsoftware.beastfactions.factions.gui.entity.page.IPage;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class GUIClickEvent extends FPlayerAbstractEvent {

    private final IGUI clickedGui;
    private final Inventory clickedInventory;
    private final IPage clickedPage;
    private final ItemStack clickedItem;
    private final IButton clickedButton;

    public GUIClickEvent(IFPlayer fPlayer, IGUI clickedGui, Inventory clickedInventory, IPage clickedPage, ItemStack clickedItem, IButton clickedButton) {
        super(fPlayer);
        this.clickedGui = clickedGui;
        this.clickedInventory = clickedInventory;
        this.clickedPage = clickedPage;
        this.clickedItem = clickedItem;
        this.clickedButton = clickedButton;
    }


    public IGUI getClickedGui() {
        return clickedGui;
    }

    public Inventory getClickedInventory() {
        return clickedInventory;
    }

    public IPage getClickedPage() {
        return clickedPage;
    }

    public ItemStack getClickedItem() {
        return clickedItem;
    }

    public IButton getClickedButton() {
        return clickedButton;
    }
}
