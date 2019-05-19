package com.beastsoftware.beastfactions.factions.event;

import com.beastsoftware.beastfactions.factions.entity.IFPlayer;
import com.beastsoftware.beastfactions.factions.entity.IFaction;
import org.bukkit.Chunk;

public class AddClaimEvent extends LandEvent {

    private IFaction faction;

    public AddClaimEvent(IFPlayer fPlayer, Chunk chunk, IFaction faction) {
        super(fPlayer, chunk);
        this.faction = faction;
    }

    @Override
    public IFaction getFaction() {

        return faction;
    }

}
