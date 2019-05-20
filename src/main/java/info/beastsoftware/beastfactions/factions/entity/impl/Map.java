package info.beastsoftware.beastfactions.factions.entity.impl;

import info.beastsoftware.beastfactions.factions.entity.IFactionsLocation;
import info.beastsoftware.beastfactions.factions.entity.IMap;
import org.bukkit.Location;

public class Map implements IMap {

    private int size;
    private IFactionsLocation center;


    public Map(int size, Location center) {
        this.size = size;
        this.center = new FactionsLocation(center);
    }


    public Map(int size, IFactionsLocation center) {
        this.size = size;
        this.center = center;
    }


    public int getSize() {
        return size;
    }

    public IFactionsLocation getCenter() {
        return center;
    }

}
