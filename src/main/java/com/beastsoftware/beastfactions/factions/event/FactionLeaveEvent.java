package com.beastsoftware.beastfactions.factions.event;

import com.beastsoftware.beastfactions.factions.entity.IFPlayer;
import com.beastsoftware.beastfactions.factions.entity.IFaction;
import org.bukkit.entity.Player;

public class FactionLeaveEvent extends FactionEvent {
    public FactionLeaveEvent(Player player, IFPlayer fPlayer, IFaction faction) {
        super(player, fPlayer, faction);
    }
}
