package com.beastsoftware.beastfactions.factions.event;

import com.beastsoftware.beastfactions.factions.entity.IFPlayer;
import org.bukkit.Location;


public class HomeWarmUpEndEvent extends WarmUpRemoveEvent {

    private Location location;

    public HomeWarmUpEndEvent(IFPlayer fPlayer, Location location) {
        super(fPlayer);
        this.location = location;
    }


    public Location getLocation() {
        return location;
    }
}
