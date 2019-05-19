package com.beastsoftware.beastfactions.factions.event.callback;

import com.beastsoftware.beastfactions.factions.entity.IFaction;
import org.bukkit.Location;

public class GetFactionCallBackEvent extends CallBackEvent {


    private IFaction faction;
    private long id;
    private Location location;

    public GetFactionCallBackEvent(long id) {
        this.id = id;
    }

    public GetFactionCallBackEvent(Location location) {
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }

    public long getId() {
        return id;
    }

    public IFaction getFaction() {
        return faction;
    }

    public void setFaction(IFaction faction) {
        this.faction = faction;
    }
}
