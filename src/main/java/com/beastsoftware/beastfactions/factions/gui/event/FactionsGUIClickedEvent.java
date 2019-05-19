package com.beastsoftware.beastfactions.factions.gui.event;

import com.beastsoftware.beastfactions.factions.entity.IFPlayer;
import com.beastsoftware.beastfactions.factions.entity.IFaction;
import com.beastsoftware.beastfactions.factions.gui.entity.button.IButton;
import com.beastsoftware.beastfactions.factions.gui.entity.gui.IGUI;
import com.beastsoftware.beastfactions.factions.gui.entity.page.IPage;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public abstract class FactionsGUIClickedEvent extends GUIClickEvent {

    private final IFaction faction;

    public FactionsGUIClickedEvent(IFPlayer fPlayer, IGUI clickedGui, Inventory clickedInventory, IPage clickedPage, ItemStack clickedItem, IButton clickedButton, IFaction faction) {
        super(fPlayer, clickedGui, clickedInventory, clickedPage, clickedItem, clickedButton);
        this.faction = faction;
    }


    public IFaction getFaction() {
        return faction;
    }
}
