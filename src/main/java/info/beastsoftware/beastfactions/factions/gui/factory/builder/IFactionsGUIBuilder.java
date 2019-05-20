package info.beastsoftware.beastfactions.factions.gui.factory.builder;

import info.beastsoftware.beastfactions.factions.entity.IFaction;
import info.beastsoftware.beastfactions.factions.gui.entity.button.IButton;
import info.beastsoftware.beastfactions.factions.gui.entity.gui.IFactionsGUI;
import info.beastsoftware.beastfactions.factions.gui.entity.page.IPage;
import org.bukkit.inventory.ItemStack;

public interface IFactionsGUIBuilder<T> extends IGUIBuilder {
    IFactionsGUI build(IFaction faction, T target);
    ItemStack getSpacerItem();

    void realTimeUpdateButton(IFaction faction, T target, IButton button, IPage page, IFactionsGUI gui);
}
