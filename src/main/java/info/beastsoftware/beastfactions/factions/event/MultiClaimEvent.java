package info.beastsoftware.beastfactions.factions.event;

import info.beastsoftware.beastfactions.factions.entity.IFPlayer;
import info.beastsoftware.beastfactions.factions.entity.IFaction;
import org.bukkit.Chunk;

public class MultiClaimEvent extends MultiLandEvent {


    public MultiClaimEvent(IFPlayer fPlayer, Chunk chunk, int radius, IFaction faction) {
        super(fPlayer, chunk, radius, faction);
    }



}
