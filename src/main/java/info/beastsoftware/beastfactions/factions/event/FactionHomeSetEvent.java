package info.beastsoftware.beastfactions.factions.event;

import info.beastsoftware.beastfactions.factions.entity.IFPlayer;
import info.beastsoftware.beastfactions.factions.entity.IFaction;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class FactionHomeSetEvent extends FactionEvent {

    private Location location;

    public FactionHomeSetEvent(Player player, IFPlayer fPlayer, IFaction faction, Location location) {
        super(player, fPlayer, faction);
        this.location = location;
    }


    public Location getLocation() {
        return location;
    }
}
