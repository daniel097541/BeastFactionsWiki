package com.beastsoftware.beastfactions.factions.util;

import com.beastsoftware.beastfactions.factions.gui.action.IAction;
import com.beastsoftware.beastfactions.factions.gui.entity.button.IButton;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import utils.StrUtils;

import java.util.List;

public class GUIUtil {


    public static Inventory createInventory(int size, String title) {
        return Bukkit.createInventory(null, size, StrUtils.translate(title));
    }


    public static ItemStack craftItem(Material material, String name, List<String> lore) {
        return craftItem(material, name, lore, null);
    }

    public static ItemStack craftItem(Material material, String name, List<String> lore, Short damage) {
        ItemStack itemStack = new ItemStack(material);
        ItemMeta meta = itemStack.getItemMeta();
        if (name != null)
            meta.setDisplayName(StrUtils.translate(name));
        if (lore != null && !lore.isEmpty())
            meta.setLore(StrUtils.translateLore(lore));
        itemStack.setItemMeta(meta);
        if (damage != null)
            itemStack.setDurability(damage);
        return itemStack;
    }


    public static IButton craftButton(String mat, String name, List<String> lore, IAction action, int position) {


        return null;// new Button(item,position,action);
    }


}
