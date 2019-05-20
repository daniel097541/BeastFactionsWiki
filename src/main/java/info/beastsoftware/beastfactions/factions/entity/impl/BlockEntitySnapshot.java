package info.beastsoftware.beastfactions.factions.entity.impl;

import info.beastsoftware.beastfactions.factions.entity.IBlockEntitySnapshot;
import org.bukkit.Material;

public class BlockEntitySnapshot implements IBlockEntitySnapshot {


    private long value;
    private String material;


    public BlockEntitySnapshot(long value, String material) {
        this.value = value;
        this.material = material;
    }

    @Override
    public long getValue() {
        return value;
    }

    @Override
    public Material getMaterial() {
        return Material.valueOf(material);
    }
}
