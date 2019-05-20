package info.beastsoftware.beastfactions.factions.gui.entity.page;

import info.beastsoftware.beastfactions.factions.gui.entity.button.IButton;
import info.beastsoftware.beastfactions.factions.gui.struct.ButtonAction;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

public interface IPage extends Serializable {


    int getIndex();

    Inventory getInventory();

    HashMap<ButtonAction, List<IButton>> getButtons();

    IButton getButton(ItemStack itemStack);

    void loadPage();

    void loadButton(IButton button);

    void fillWithSpacers(ItemStack spacer);

}
