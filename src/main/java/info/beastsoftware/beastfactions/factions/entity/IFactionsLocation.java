package info.beastsoftware.beastfactions.factions.entity;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.util.Vector;

import java.util.UUID;

public interface IFactionsLocation {
    World getWorld();

    Location getLocation();

    int getX();

    int getY();

    int getZ();

    String getWorldName();

    Vector getDirection();

    boolean canBeClaimedByFaction(IFaction faction, IFPlayer player);

    IFaction getFactionAt();

    int distanceTo(IFactionsLocation location);

    UUID getServerName();

    IClaim getClaim();

    IFChunk getFChunk();
}
