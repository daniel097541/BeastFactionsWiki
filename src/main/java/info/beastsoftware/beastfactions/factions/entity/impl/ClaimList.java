package info.beastsoftware.beastfactions.factions.entity.impl;

import info.beastsoftware.beastfactions.factions.entity.IClaim;
import info.beastsoftware.beastfactions.factions.entity.IClaimList;
import info.beastsoftware.beastfactions.factions.entity.IFChunk;
import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ClaimList implements IClaimList {

    @Expose(serialize = false)
    private HashMap<IFChunk, IClaim> cache;

    @Expose
    private List<IClaim> claims = new ArrayList<>();


    public ClaimList(List<IClaim> claims) {
        cache = new HashMap<>();
        setClaims(claims);
    }

    public ClaimList() {
        load();
    }

    public List<IClaim> getClaims() {
        return claims;
    }

    @Override
    public void load() {
        cache = new HashMap<>();
        addAllToCache(claims);
    }

    private void addAllToCache(List<IClaim> claims) {
        for (IClaim claim : claims)
            this.cache.putIfAbsent(claim.getFChunk(), claim);
    }

    public void setClaims(List<IClaim> claims) {
        this.clear();
        this.addAll(claims);
    }

    public void add(IClaim claim) {
        if (cache == null || cache.isEmpty())
            load();
        claims.add(claim);
        cache.putIfAbsent(claim.getFChunk(), claim);
    }

    public void remove(IClaim claim) {
        if (cache == null || cache.isEmpty())
            load();
        claims.remove(claim);
        try {
            cache.remove(claim.getFChunk());
        } catch (Exception ignored) {

        }
    }

    @Override
    public void addAll(List<IClaim> claims) {
        this.claims.addAll(claims);
        addAllToCache(claims);
    }

    @Override
    public void clear() {
        claims.clear();
        cache.clear();
    }

    @Override
    public IClaim get(IFChunk chunk) {
        if (cache == null || cache.isEmpty())
            load();
        return cache.get(chunk);
    }

    @Override
    public void removeAll(List<IClaim> claimsList) {
        claims.removeAll(claimsList);

        for(IClaim claim : claimsList)
            cache.remove(claim.getFChunk());
    }


}
