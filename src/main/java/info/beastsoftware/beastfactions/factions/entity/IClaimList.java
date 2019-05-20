package info.beastsoftware.beastfactions.factions.entity;

import java.util.List;

public interface IClaimList {

    List<IClaim> getClaims();

    void load();

    void setClaims(List<IClaim> claims);

    void add(IClaim claim);

    void remove(IClaim claim);

    void addAll(List<IClaim> claims);

    void clear();

    IClaim get(IFChunk chunk);

    void removeAll(List<IClaim> claimsList);
}
