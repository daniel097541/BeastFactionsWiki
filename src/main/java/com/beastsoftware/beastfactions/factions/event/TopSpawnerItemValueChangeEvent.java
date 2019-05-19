package com.beastsoftware.beastfactions.factions.event;

import org.bukkit.entity.EntityType;

public class TopSpawnerItemValueChangeEvent extends TopItemValueChangeEvent {

    private EntityType type;

    public TopSpawnerItemValueChangeEvent(long price, EntityType type) {
        super(price);
        this.type = type;
    }

    public EntityType getType() {
        return type;
    }
}
