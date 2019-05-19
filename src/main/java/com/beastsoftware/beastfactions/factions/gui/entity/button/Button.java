package com.beastsoftware.beastfactions.factions.gui.entity.button;

import com.beastsoftware.beastfactions.BeastFactions;
import com.beastsoftware.beastfactions.factions.gui.action.IAction;
import com.beastsoftware.beastfactions.factions.gui.struct.ButtonAction;
import com.beastsoftware.beastfactions.factions.gui.struct.GUIType;
import com.beastsoftware.beastfactions.factions.util.GUIUtil;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;
import utils.StrUtils;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;


public abstract class Button implements IButton {

    protected ItemStack item;
    protected int index;
    protected IAction action;
    private final UUID uuid;


    public Button(IAction action) {
        this.action = action;
        uuid = UUID.randomUUID();
    }

    public Button(Button button, IAction action) {
        item = button.item.clone();
        index = button.index;
        this.action = action;
        uuid = UUID.randomUUID();
    }

    @Override
    public ItemStack getItem() {
        return item;
    }

    @Override
    public int getIndex() {
        return index;
    }


    @Override
    public IAction getAction() {
        return action;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Button button = (Button) o;
        return index == button.index &&
                item.equals(button.item) && button.uuid.equals(uuid);
    }

    @Override
    public int hashCode() {
        return item.hashCode() * index * uuid.hashCode();
    }

    @Override
    public void setIndex(int index) {
        this.index = index;
    }


    @Override
    public void craftButton(YamlConfiguration config, HashMap<String, String> placeholders, GUIType guiType, String subPath, ButtonAction buttonAction, Material defaultMaterial) {
        String path = guiType.getPath();
        path = path + subPath;

        String name = config.getString(path + "name");
        List<String> lore = config.getStringList(path + "lore");

        name = StrUtils.craftMessageWithPlaceHolders(name, placeholders);
        lore = StrUtils.craftMessageWithPlaceHolders(lore, placeholders);

        this.index = config.getInt(path + "position");
        Material material;
        short damage;

        try {
            String mat = config.getString(path + "material");
            material = Material.valueOf(mat);
        } catch (Exception ignored) {
            material = defaultMaterial;
            BeastFactions.getInstance().getServer().getLogger().info("BeastFactions > WARNING!" + buttonAction.name() + " button material is not valid! Use another material for it!");
        }

        try {
            int dam = config.getInt(path + "damage");
            damage = Short.valueOf(dam + "");
        } catch (Exception ignored) {
            damage = Short.valueOf("0");
            BeastFactions.getInstance().getServer().getLogger().info("BeastFactions > WARNING!" + buttonAction.name() + " button damage is not valid! Use another damage for it!");
        }

        this.item = GUIUtil.craftItem(material, name, lore, damage);
    }


    @Override
    public void setItem(ItemStack item) {
        this.item = item;
    }
}
