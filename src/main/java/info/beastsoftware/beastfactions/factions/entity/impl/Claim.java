package info.beastsoftware.beastfactions.factions.entity.impl;

import info.beastsoftware.beastfactions.BeastFactions;
import info.beastsoftware.beastfactions.factions.entity.*;
import info.beastsoftware.beastfactions.factions.util.ChunkUtil;
import com.google.gson.annotations.Expose;
import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.World;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Claim implements IClaim {


    @Expose
    private String serverName;

    @Expose
    private long factionId;

    @Expose
    private UUID claimer;

    @Expose
    private int x;

    @Expose
    private int z;

    @Expose
    private String worldName;

    @Expose
    private Date claimDate;

    public Claim(long factionId, UUID claimer, Chunk chunk, String worldName) {
        this.factionId = factionId;
        this.claimer = claimer;
        this.x = chunk.getX();
        this.z = chunk.getZ();
        this.worldName = worldName;
        this.claimDate = new Date();
        this.serverName = BeastFactions.getInstance().getInternalApi().getServerName().toString();
    }

    public Claim(long factionId, UUID claimer, int x, int z, String worldName, Date claimDate) {
        this.factionId = factionId;
        this.claimer = claimer;
        this.x = x;
        this.z = z;
        this.worldName = worldName;
        this.claimDate = (Date) claimDate.clone();
        this.serverName = BeastFactions.getInstance().getInternalApi().getServerName().toString();
    }

    public Claim(IFChunk chunk, UUID claimer, long factionId) {
        this.factionId = factionId;
        this.x = chunk.getX();
        this.worldName = chunk.getWorldName();
        this.z = chunk.getZ();
        this.claimDate = new Date();
        this.claimer = claimer;
        this.serverName = BeastFactions.getInstance().getInternalApi().getServerName().toString();
    }

    @Override
    public IFaction getFaction() {
        return BeastFactions.getInstance().getInternalApi().getFactionFromId(factionId);
    }

    @Override
    public IFPlayer getClaimer() {
        return BeastFactions.getInstance().getInternalApi().getFPlayer(claimer);
    }

    @Override
    public Chunk getChunk() {
        return getWorld().getChunkAt(x, z);
    }

    @Override
    public IFChunk getFChunk() {
        return new FChunk(x, z, worldName);
    }

    @Override
    public World getWorld() {
        return Bukkit.getWorld(worldName);
    }

    @Override
    public long getFactionId() {
        return factionId;
    }

    @Override
    public Date getClaimDate() {
        return (Date) claimDate.clone();
    }


    @Override
    public String getServerName() {
        return serverName;
    }

    @Override
    public void setServerName(String serverName) {
        this.serverName = serverName;
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
    public List<IFPlayer> getPlayersInside() {
        return ChunkUtil.getFPlayersInChunk(getChunk());
    }

    @Override
    public List<IFactionWarp> getWarpsInside() {

        IFaction faction = getFaction();
        List<IFactionWarp> warps = new ArrayList<>();

        for (IFactionWarp warp : faction.getWarps()) {
            if (warp.getFChunk().equals(this.getFChunk()))
                warps.add(warp);
        }

        return warps;
    }

    @Override
    public int hashCode() {
        return worldName.hashCode() * x * z;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Claim)) return false;

        Claim claim = (Claim) obj;

        if (!claim.worldName.equals(worldName)) return false;

        if (x != claim.x) return false;

        return z == claim.z;
    }
}
