package info.beastsoftware.beastfactions.factions.event;

import info.beastsoftware.beastfactions.factions.entity.IFPlayer;
import org.bukkit.Location;

public class FPlayerTeleportToHomeEvent extends FPlayerAbstractEvent {
    private Location location;

    public FPlayerTeleportToHomeEvent(IFPlayer fPlayer, Location location) {
        super(fPlayer);
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }
}
