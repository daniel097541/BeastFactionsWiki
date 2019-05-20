package info.beastsoftware.beastfactions.factions.entity.impl;

import info.beastsoftware.beastfactions.BeastFactions;
import com.beastsoftware.beastfactions.factions.entity.*;
import info.beastsoftware.beastfactions.factions.entity.*;
import info.beastsoftware.beastfactions.factions.event.callback.GetFactionCallBackEvent;
import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.util.Vector;
import utils.ILocationUtil;

import java.util.UUID;

public class FactionsLocation implements IFactionsLocation {

    private int x;
    private int y;
    private int z;
    private String worldName;
    private Vector direction;
    private final String serverName;

    FactionsLocation(int x, int y, int z, String worldName, Vector direction) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.worldName = worldName;
        this.direction = direction;
        this.serverName = BeastFactions.getInstance().getInternalApi().getServerName().toString();
    }


    public FactionsLocation(Chunk chunk) {
        Location location = chunk.getBlock(0, 0, 0).getLocation();
        this.x = location.getBlockX();
        this.y = location.getBlockY();
        this.z = location.getBlockZ();
        this.worldName = location.getWorld().getName();
        this.direction = location.getDirection();
        this.serverName = BeastFactions.getInstance().getInternalApi().getServerName().toString();
    }

    public FactionsLocation(Location location) {
        this.x = location.getBlockX();
        this.y = location.getBlockY();
        this.z = location.getBlockZ();
        this.worldName = location.getWorld().getName();
        this.direction = location.getDirection();
        this.serverName = BeastFactions.getInstance().getInternalApi().getServerName().toString();
    }

    public World getWorld() {
        return Bukkit.getWorld(worldName);
    }

    public Location getLocation() {
        Location location = new Location(getWorld(), x, y, z);
        location.setDirection(direction);
        return location;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }

    public String getWorldName() {
        return worldName;
    }

    public Vector getDirection() {
        return direction;
    }

    @Override
    public boolean canBeClaimedByFaction(IFaction faction, IFPlayer player) {

        GetFactionCallBackEvent event = new GetFactionCallBackEvent(getLocation());
        Bukkit.getPluginManager().callEvent(event);

        IFaction fAt = event.getFaction();

        if (ILocationUtil.isOutsideBorder(getX(), getZ(), getWorld().getWorldBorder())) return false;

        if (faction.isDefaultFaction()) return true;

        if (fAt == null)
            return true;

        long id = fAt.getId();

        if (id == 0) return true;

        if (id == faction.getId()) return false;

        if (!faction.canClaim(player)) return false;

        if (fAt.isDefaultFaction() && !fAt.isFactionless()) return false;

        if (fAt.isFactionless()) return true;

        return fAt.canBeOverClaimed();
    }

    @Override
    public IFaction getFactionAt() {
        return BeastFactions.getInstance().getInternalApi().getFactionAtLocation(getLocation());
    }

    @Override
    public int distanceTo(IFactionsLocation location) {
        return (int) getLocation().distance(location.getLocation());
    }

    @Override
    public UUID getServerName() {
        return UUID.fromString(serverName);
    }

    @Override
    public IClaim getClaim() {
        return BeastFactions.getInstance().getInternalApi().getClaimAt(getLocation().getChunk(), getFactionAt());
    }

    @Override
    public IFChunk getFChunk() {
        return new FChunk(getLocation().getChunk());
    }


}
