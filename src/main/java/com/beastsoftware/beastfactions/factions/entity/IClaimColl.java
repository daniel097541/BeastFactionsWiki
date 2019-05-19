package com.beastsoftware.beastfactions.factions.entity;

import org.bukkit.Chunk;

import java.util.List;

public interface IClaimColl {

    List<IClaim> getClaims();

    void loadCache();

    IFaction getFaction();

    void addClaim(IClaim claim);

    void removeClaim(IClaim claim);

    void removeClaimAtFChunk(IFChunk chunk);

    IClaim getClaimAtChunk(Chunk chunk);

    IClaim getClaimAtChunkCoordinates(int x, int z, String worldName);

    void addAll(List<IClaim> claims);

    IClaimList getClaimList();

    void save();

    void removeAll(List<IClaim> claimsList);

    long getFactionId();
}
