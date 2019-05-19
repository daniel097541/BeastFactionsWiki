package com.beastsoftware.beastfactions.factions.event;

import com.beastsoftware.beastfactions.factions.entity.IFPlayer;
import com.beastsoftware.beastfactions.factions.entity.IFaction;
import org.bukkit.entity.Player;

public class FactionJoinEvent extends FactionEvent {
    public FactionJoinEvent(Player player, IFPlayer fPlayer, IFaction faction) {
        super(player, fPlayer, faction);
    }
}
