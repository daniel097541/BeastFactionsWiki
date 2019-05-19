package com.beastsoftware.beastfactions.factions.event;

import com.beastsoftware.beastfactions.factions.entity.IFPlayer;
import org.bukkit.entity.Player;

public class FPlayerSaveEvent extends FPlayerEvent {
    public FPlayerSaveEvent(Player player, IFPlayer fPlayer) {
        super(player, fPlayer);
    }
}
