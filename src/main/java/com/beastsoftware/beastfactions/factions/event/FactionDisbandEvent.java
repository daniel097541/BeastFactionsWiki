package com.beastsoftware.beastfactions.factions.event;

import com.beastsoftware.beastfactions.factions.entity.IFPlayer;
import com.beastsoftware.beastfactions.factions.entity.IFaction;
import org.bukkit.entity.Player;

public class FactionDisbandEvent extends FactionEvent {
    public FactionDisbandEvent(Player player, IFPlayer fPlayer, IFaction faction) {
        super(player, fPlayer, faction);
    }
}
