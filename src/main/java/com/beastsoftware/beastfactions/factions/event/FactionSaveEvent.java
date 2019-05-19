package com.beastsoftware.beastfactions.factions.event;

import com.beastsoftware.beastfactions.factions.entity.IFaction;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class FactionSaveEvent extends Event {
    private static final HandlerList handlers = new HandlerList();

    private IFaction faction;

    public FactionSaveEvent(IFaction faction) {
        this.faction = faction;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }


    public IFaction getFaction() {
        return faction;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }
}
