package info.beastsoftware.beastfactions.factions.gui.entity.button;

import info.beastsoftware.beastfactions.BeastFactions;
import info.beastsoftware.beastfactions.factions.gui.action.IAction;
import info.beastsoftware.beastfactions.factions.gui.struct.ButtonAction;
import info.beastsoftware.beastfactions.factions.gui.struct.CommonButtonPath;
import info.beastsoftware.beastfactions.factions.gui.struct.GUIType;
import info.beastsoftware.beastfactions.factions.util.GUIUtil;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class CommonButton extends Button {

    private final CommonButtonPath path;
    private final String pathPos;

    CommonButton(IAction action, CommonButtonPath path, String pathPos) {
        super(action);
        this.path = path;
        this.pathPos = pathPos;
    }

    public CommonButton(CommonButton button, IAction action) {
        super(button, action);
        this.path = button.path;
        this.pathPos = button.pathPos;
    }

    @Override
    public void craftButton(YamlConfiguration config, HashMap<String, String> placeholders, GUIType guiType, String subPath, ButtonAction buttonAction, Material defaultMaterial) {

        String path = this.path.getPath();

        String name = config.getString(path + "name");
        Material material;
        try {
            String mat = config.getString(path + "material");
            material = Material.valueOf(mat);
        } catch (IllegalArgumentException ignored) {
            material = defaultMaterial;
            BeastFactions.getInstance().getServer().getLogger().info("BeastFactions > WARNING!" + this.path.name() + " material is not valid! Use another material for it!");
        }

        short damage;
        try {
            int dam = config.getInt(path + "damage");
            damage = Short.parseShort(dam + "");
        } catch (Exception ignored) {
            damage = Short.parseShort("0");
            BeastFactions.getInstance().getServer().getLogger().info("BeastFactions > WARNING!" + this.path.name() + " damage is not valid! Use a valid damage for it!");
        }

        item = GUIUtil.craftItem(material, name, new ArrayList<>(), damage);

        this.index = config.getInt(pathPos);
    }
}
