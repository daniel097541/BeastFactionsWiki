package com.beastsoftware.beastfactions.factions.event;

import org.bukkit.Material;

public class TopBlockItemValueChangeEvent extends TopItemValueChangeEvent {

    private Material material;

    public TopBlockItemValueChangeEvent(long price, Material material) {
        super(price);
        this.material = material;
    }

    public Material getMaterial() {
        return material;
    }
}
