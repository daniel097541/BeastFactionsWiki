package com.beastsoftware.beastfactions.factions.event;

import com.beastsoftware.beastfactions.factions.entity.IClaimColl;
import com.beastsoftware.beastfactions.factions.entity.IFaction;

public class ClaimCollSaveEvent extends SimpleFactionEvent {

    private IClaimColl claimColl;

    public ClaimCollSaveEvent(IFaction faction, IClaimColl claimColl) {
        super(faction);
        this.claimColl = claimColl;
    }

    public IClaimColl getClaimColl() {
        return claimColl;
    }
}
