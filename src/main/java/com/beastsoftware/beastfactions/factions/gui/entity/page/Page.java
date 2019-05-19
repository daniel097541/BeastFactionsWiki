package com.beastsoftware.beastfactions.factions.gui.entity.page;

import com.beastsoftware.beastfactions.factions.gui.entity.button.IButton;
import com.beastsoftware.beastfactions.factions.gui.struct.ButtonAction;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import utils.IInventoryUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public abstract class Page implements IPage {


    private final Inventory inventory;
    private final int index;
    private final HashMap<ButtonAction, List<IButton>> buttons;


    public Page(Inventory inventory, int index, HashMap<ButtonAction, List<IButton>> buttons) {
        this.inventory = inventory;
        this.index = index;
        this.buttons = buttons;
    }


    @Override
    public int getIndex() {
        return index;
    }

    @Override
    public Inventory getInventory() {
        return inventory;
    }

    @Override
    public HashMap<ButtonAction, List<IButton>> getButtons() {
        return buttons;
    }

    @Override
    public void loadPage() {
        for (List<IButton> buttonList : buttons.values()) {
            for (IButton button : buttonList)
                loadButton(button);
        }
    }

    @Override
    public void loadButton(IButton button) {
        inventory.setItem(button.getIndex(), button.getItem());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Page page = (Page) o;
        return index == page.index &&
                inventory.equals(page.inventory) &&
                buttons.equals(page.buttons);
    }

    @Override
    public int hashCode() {
        return Objects.hash(inventory, index, buttons);
    }

    @Override
    public IButton getButton(ItemStack itemStack) {

        for (List<IButton> buttonList : buttons.values()) {
            for (IButton button : buttonList) {
                if (button.getItem().equals(itemStack))
                    return button;
            }
        }

        return null;
    }

    @Override
    public void fillWithSpacers(ItemStack spacer) {
        IInventoryUtil.fillEmptySlots(inventory, spacer);
    }
}
