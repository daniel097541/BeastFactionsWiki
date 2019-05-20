package info.beastsoftware.beastfactions.factions.event;

import info.beastsoftware.beastfactions.factions.entity.IClaim;
import info.beastsoftware.beastfactions.factions.entity.IFPlayer;
import info.beastsoftware.beastfactions.factions.entity.IFaction;

import java.util.List;

public class MultiUnclaimTaskEndEvent extends MultiLandTaskEndEvent {

    private final List<IClaim> claims;

    public MultiUnclaimTaskEndEvent(int claimed, IFPlayer player, IFaction faction, List<IClaim> claims) {
        super(claimed, player, faction);
        this.claims = claims;
    }


    public List<IClaim> getClaims() {
        return claims;
    }
}
