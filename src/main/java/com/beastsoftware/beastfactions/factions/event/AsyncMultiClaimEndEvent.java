package com.beastsoftware.beastfactions.factions.event;

import com.beastsoftware.beastfactions.factions.entity.IClaim;
import com.beastsoftware.beastfactions.factions.entity.IFPlayer;
import com.beastsoftware.beastfactions.factions.entity.IFaction;

import java.util.List;

public class AsyncMultiClaimEndEvent extends SimpleFactionEvent {


    private final List<IClaim> claims;
    private final IFPlayer player;


    public AsyncMultiClaimEndEvent(IFaction faction, List<IClaim> claims, IFPlayer player) {
        super(faction);
        this.claims = claims;
        this.player = player;
    }


    public IFPlayer getPlayer() {
        return player;
    }

    public List<IClaim> getClaims() {
        return claims;
    }
}
