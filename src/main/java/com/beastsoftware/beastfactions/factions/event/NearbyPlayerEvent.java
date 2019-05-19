package com.beastsoftware.beastfactions.factions.event;

import com.beastsoftware.beastfactions.factions.entity.IFPlayer;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class NearbyPlayerEvent extends Event {
    private static final HandlerList handlers = new HandlerList();

    private IFPlayer target;
    private IFPlayer nearbyPlayer;

    public NearbyPlayerEvent(IFPlayer target, IFPlayer nearbyPlayer) {
        this.target = target;
        this.nearbyPlayer = nearbyPlayer;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    public IFPlayer getTarget() {
        return target;
    }

    public IFPlayer getNearbyPlayers() {
        return nearbyPlayer;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }
}
