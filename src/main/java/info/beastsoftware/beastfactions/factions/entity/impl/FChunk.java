package info.beastsoftware.beastfactions.factions.entity.impl;

import info.beastsoftware.beastfactions.BeastFactions;
import info.beastsoftware.beastfactions.factions.entity.IFChunk;
import info.beastsoftware.beastfactions.factions.entity.IFPlayer;
import info.beastsoftware.beastfactions.factions.entity.IFaction;
import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.World;
import utils.ILocationUtil;

import java.util.UUID;

public class FChunk implements IFChunk {


    private int x;
    private int z;
    private String worldName;
    private String serverName;


    public FChunk(int x, int z, String worldName) {
        this.x = x;
        this.z = z;
        this.worldName = worldName;
    }

    public FChunk(Chunk chunk) {
        this.x = chunk.getChunkSnapshot().getX();
        this.z = chunk.getChunkSnapshot().getZ();
        this.worldName = chunk.getChunkSnapshot().getWorldName();
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getZ() {
        return z;
    }

    @Override
    public String getWorldName() {
        return worldName;
    }

    @Override
    public World getWorld() {
        return Bukkit.getWorld(worldName);
    }

    @Override
    public Chunk getChunk() {
        return getWorld().getChunkAt(x, z);
    }

    @Override
    public boolean canBeClaimedByFaction(IFaction faction, IFPlayer player) {
        IFaction fAt = BeastFactions.getInstance().getInternalApi().getFactionAtChunkCoords(x, z, worldName);

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
        return BeastFactions.getInstance().getInternalApi().getFactionAtChunkCoords(x, z, worldName);
    }

    @Override
    public UUID getServerName() {
        return UUID.fromString(serverName);
    }

    @Override
    public boolean isClaimed() {
        return getFactionAt() != null;
    }

    @Override
    public void clearClaim() {
        getFactionAt().removeClaimAtFChunk(this);
    }

    @Override
    public int hashCode() {
        return worldName.hashCode() * x * z;
    }

    @Override
    public boolean equals(Object obj) {

        if (!(obj instanceof FChunk)) return false;

        FChunk fChunk = (FChunk) obj;

        if (!fChunk.worldName.equals(this.worldName)) return false;

        if (fChunk.getX() != x) return false;

        return fChunk.getZ() == z;
    }


}
