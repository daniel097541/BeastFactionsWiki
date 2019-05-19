package com.beastsoftware.beastfactions.factions.entity.impl;

import com.beastsoftware.beastfactions.BeastFactions;
import com.beastsoftware.beastfactions.factions.entity.IBlockTopEntity;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;

public class BlockTopEntity implements IBlockTopEntity {


    private FactionsLocation location;

    private String material;


    public BlockTopEntity(Location location, Material material) {
        this.location = new FactionsLocation(location);
        this.material = material.toString();
    }



    @Override
    public Block getBlock() {
        return location.getWorld().getBlockAt(getLocation());
    }

    @Override
    public Location getLocation() {
        return location.getLocation();
    }

    @Override
    public Material getMaterial() {
        return Material.valueOf(material);
    }

    @Override
    public long getValue() {
        return BeastFactions.getInstance().getInternalApi().getTop().getTopValue(this);
    }
}
