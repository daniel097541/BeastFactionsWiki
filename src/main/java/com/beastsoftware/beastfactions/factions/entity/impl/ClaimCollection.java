package com.beastsoftware.beastfactions.factions.entity.impl;

import com.beastsoftware.beastfactions.BeastFactions;
import com.beastsoftware.beastfactions.factions.entity.*;
import com.beastsoftware.beastfactions.factions.event.ClaimCollSaveEvent;
import com.google.gson.annotations.Expose;
import org.bukkit.Bukkit;
import org.bukkit.Chunk;

import java.util.List;

public class ClaimCollection implements IClaimColl {


    @Expose
    private final IClaimList claims;

    @Expose
    private final long factionId;

//    @Expose(serialize = false)
//    private HashMap<IFChunk, IClaim> claimsCache;


    public long getFactionId() {
        return factionId;
    }

    public ClaimCollection(List<IClaim> claims, long factionId) {
        this.claims = new ClaimList(claims);
        this.factionId = factionId;
    }

    public ClaimCollection(ClaimList claims, long factionId) {
        this.claims = claims;
        this.factionId = factionId;
    }

    @Override
    public List<IClaim> getClaims() {
        return claims.getClaims();
    }

    @Override
    public void loadCache() {
        claims.load();
    }

//    @Override
//    public void loadCache() {
//        this.claimsCache = new HashMap<>();
//        for (IClaim c : claims.getClaims()) {
//            IFChunk chunk = new FChunk(c.getX(), c.getZ(), c.getWorldName());
//            claimsCache.put(chunk, c);
//        }
//    }

    @Override
    public IFaction getFaction() {
        return BeastFactions.getInstance().getInternalApi().getFactionFromId(factionId);
    }

    @Override
    public void addClaim(IClaim claim) {
        claims.add(claim);
        IFChunk fChunk = new FChunk(claim.getX(), claim.getZ(), claim.getWorldName());
//        claimsCache.put(fChunk, claim);
    }

    @Override
    public void removeClaim(IClaim claim) {
        claims.remove(claim);
        IFChunk chunk = new FChunk(claim.getX(), claim.getZ(), claim.getWorldName());
//        claimsCache.remove(chunk);
    }

    @Override
    public void removeClaimAtFChunk(IFChunk chunk) {
        claims.remove(getClaimAtChunkCoordinates(chunk.getX(), chunk.getZ(), chunk.getWorldName()));
//        claimsCache.remove(chunk);
    }

    @Override
    public IClaim getClaimAtChunk(Chunk chunk) {
        return getClaimAtChunkCoordinates(chunk.getChunkSnapshot().getX(), chunk.getChunkSnapshot().getZ(), chunk.getChunkSnapshot().getWorldName());
    }

    @Override
    public IClaim getClaimAtChunkCoordinates(int x, int z, String worldName) {
        IFChunk chunk = new FChunk(x, z, worldName);
        return claims.get(chunk);
    }

    @Override
    public void addAll(List<IClaim> claims) {
        this.claims.addAll(claims);
    }

    @Override
    public IClaimList getClaimList() {
        return claims;
    }

    @Override
    public void save() {
        Bukkit.getPluginManager().callEvent(new ClaimCollSaveEvent(getFaction(), this));
    }

    @Override
    public void removeAll(List<IClaim> claimsList) {
        claims.removeAll(claimsList);
    }
}
