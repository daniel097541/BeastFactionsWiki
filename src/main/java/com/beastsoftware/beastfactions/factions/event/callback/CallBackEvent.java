package com.beastsoftware.beastfactions.factions.event.callback;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public abstract class CallBackEvent extends Event {
    private static final HandlerList handlers = new HandlerList();

    public CallBackEvent() {
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }


}
