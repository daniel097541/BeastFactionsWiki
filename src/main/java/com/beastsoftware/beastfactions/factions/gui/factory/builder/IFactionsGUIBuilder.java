package com.beastsoftware.beastfactions.factions.gui.factory.builder;

import com.beastsoftware.beastfactions.factions.entity.IFaction;
import com.beastsoftware.beastfactions.factions.gui.entity.button.IButton;
import com.beastsoftware.beastfactions.factions.gui.entity.gui.IFactionsGUI;
import com.beastsoftware.beastfactions.factions.gui.entity.page.IPage;
import org.bukkit.inventory.ItemStack;

public interface IFactionsGUIBuilder<T> extends IGUIBuilder {
    IFactionsGUI build(IFaction faction, T target);
    ItemStack getSpacerItem();

    void realTimeUpdateButton(IFaction faction, T target, IButton button, IPage page, IFactionsGUI gui);
}
