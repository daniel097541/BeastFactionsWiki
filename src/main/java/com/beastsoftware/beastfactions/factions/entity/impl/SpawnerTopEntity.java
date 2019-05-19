package com.beastsoftware.beastfactions.factions.entity.impl;

import com.beastsoftware.beastfactions.BeastFactions;
import com.beastsoftware.beastfactions.factions.entity.ISpawnerTopEntity;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;


public class SpawnerTopEntity implements ISpawnerTopEntity {

    private String spawnerType;
    private FactionsLocation location;

    public SpawnerTopEntity(String spawnerType, FactionsLocation location) {
        this.spawnerType = spawnerType;
        this.location = location;
    }

    public SpawnerTopEntity(String spawnerType, Location location) {
        this.spawnerType = spawnerType;
        this.location = new FactionsLocation(location);
    }

    @Override
    public String getType() {
        return spawnerType;
    }

    @Override
    public int getAmountStacked() {
        if (!BeastFactions.getInstance().getInternalApi().isHookedIntoEpicSpawners())
            return 1;

        return BeastFactions.getInstance().getInternalApi().getAmountOfSpawnersStacked(getLocation());
    }

    @Override
    public Block getBlock() {
        return location.getLocation().getBlock();
    }

    @Override
    public Location getLocation() {
        return location.getLocation();
    }

    @Override
    public Material getMaterial() {
        return Material.getMaterial("MOB_SPAWNER");
    }

    @Override
    public long getValue() {
        return BeastFactions.getInstance().getInternalApi().getTop().getTopValue(this);
    }
}
