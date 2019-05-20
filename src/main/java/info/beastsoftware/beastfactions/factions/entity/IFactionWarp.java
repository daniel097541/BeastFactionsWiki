package info.beastsoftware.beastfactions.factions.entity;

import info.beastsoftware.beastfactions.factions.entity.impl.Permission;
import org.bukkit.Location;

import java.io.Serializable;

public interface IFactionWarp extends Serializable {

    String getName();

    Permission getPermission();

    Location getLocation();

    void setLocation(Location location);

    IFChunk getFChunk();

}
