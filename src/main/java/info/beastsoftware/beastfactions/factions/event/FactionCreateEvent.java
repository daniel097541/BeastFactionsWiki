package info.beastsoftware.beastfactions.factions.event;

import info.beastsoftware.beastfactions.factions.entity.IFPlayer;
import info.beastsoftware.beastfactions.factions.entity.IFaction;
import org.bukkit.entity.Player;

public class FactionCreateEvent extends FactionEvent {
    public FactionCreateEvent(Player player, IFPlayer fPlayer, IFaction faction) {
        super(player, fPlayer, faction);
    }
}
