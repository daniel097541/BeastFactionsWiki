package com.beastsoftware.beastfactions.factions.gui.entity.gui;

import com.beastsoftware.beastfactions.factions.entity.IFPlayer;
import com.beastsoftware.beastfactions.factions.entity.IFaction;
import com.beastsoftware.beastfactions.factions.gui.entity.button.IButton;
import com.beastsoftware.beastfactions.factions.gui.entity.page.IPage;
import com.beastsoftware.beastfactions.factions.gui.struct.GUIType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.io.Serializable;
import java.util.List;

public interface IGUI extends Serializable {


    GUIType getGuiType();

    IPage getPage(int index);

    void loadGUI();

    boolean isPage(Inventory inventory);

    IPage getPage(Inventory inventory);

    int getPageIndex(Inventory inventory);

    int getSize();

    void fillWithSpacers(ItemStack spacer);

    boolean mustBeStoredInCache();

    List<IFPlayer> getWatchers();

    void callEventClicked(IFPlayer player, IFaction faction, Inventory clickedInventory,
                          IPage clickedPage, ItemStack clickedItem, IButton clickedButton);


}
