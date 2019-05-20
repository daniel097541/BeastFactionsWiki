package info.beastsoftware.beastfactions.factions.gui.entity.button;

import info.beastsoftware.beastfactions.factions.gui.action.IAction;
import info.beastsoftware.beastfactions.factions.gui.struct.ButtonAction;
import info.beastsoftware.beastfactions.factions.gui.struct.GUIType;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;

import java.io.Serializable;
import java.util.HashMap;

public interface IButton extends Serializable, Cloneable {


    ItemStack getItem();

    int getIndex();

    IAction getAction();

    void craftButton(YamlConfiguration config, HashMap<String, String> placeholders, GUIType guiType, String subPath, ButtonAction buttonAction, Material defaultMaterial);

    void setIndex(int index);

    void setItem(ItemStack item);

}
