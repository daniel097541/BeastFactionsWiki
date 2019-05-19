package com.beastsoftware.beastfactions.factions.event;

import com.beastsoftware.beastfactions.factions.entity.IClaim;
import com.beastsoftware.beastfactions.factions.entity.IFaction;

import java.util.List;

public class RemoveEntitiesFromClaimsEvent extends SimpleFactionEvent {

    private final List<IClaim> claimList;

    public RemoveEntitiesFromClaimsEvent(IFaction faction, List<IClaim> claimList) {
        super(faction);
        this.claimList = claimList;
    }

    public List<IClaim> getClaimList() {
        return claimList;
    }
}
