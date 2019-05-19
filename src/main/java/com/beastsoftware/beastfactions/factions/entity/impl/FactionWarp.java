package com.beastsoftware.beastfactions.factions.entity.impl;

import com.beastsoftware.beastfactions.factions.entity.IFChunk;
import com.beastsoftware.beastfactions.factions.entity.IFactionWarp;
import com.beastsoftware.beastfactions.factions.entity.IFactionsLocation;
import org.bukkit.Location;

import java.util.Objects;

public class FactionWarp implements IFactionWarp {


    private String name;
    private IFactionsLocation location;


    public FactionWarp(String name, Location location) {
        this.name = name;
        this.location = new FactionsLocation(location);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Permission getPermission() {
        return new Permission("WARP_" + name);
    }

    @Override
    public Location getLocation() {
        return location.getLocation();
    }

    @Override
    public void setLocation(Location location) {
        this.location = new FactionsLocation(location);
    }

    @Override
    public IFChunk getFChunk() {
        return new FChunk(location.getLocation().getChunk());
    }


    @Override
    public int hashCode() {
        return name.hashCode() * location.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FactionWarp that = (FactionWarp) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(location, that.location);
    }
}
