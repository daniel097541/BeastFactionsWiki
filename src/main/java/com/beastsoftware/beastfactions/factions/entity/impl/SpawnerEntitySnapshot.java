package com.beastsoftware.beastfactions.factions.entity.impl;

import com.beastsoftware.beastfactions.factions.entity.ISpawnerEntitySnapShot;
import org.bukkit.entity.EntityType;

public class SpawnerEntitySnapshot implements ISpawnerEntitySnapShot {


    private long amount;
    private long value;
    private String type;

    public SpawnerEntitySnapshot(long amount, long value, String type) {
        this.amount = amount;
        this.value = value;
        this.type = type;
    }

    @Override
    public long getAmount() {
        return amount;
    }

    @Override
    public long getValue() {
        return value;
    }

    @Override
    public EntityType getType() {
        return EntityType.fromName(type);
    }
}
