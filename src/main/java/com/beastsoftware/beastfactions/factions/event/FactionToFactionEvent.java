package com.beastsoftware.beastfactions.factions.event;

import com.beastsoftware.beastfactions.factions.entity.IFPlayer;
import com.beastsoftware.beastfactions.factions.entity.IFaction;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public abstract class FactionToFactionEvent extends Event implements Cancellable {
    private static final HandlerList handlers = new HandlerList();

    private IFPlayer triggerPlayer;
    private IFaction sender;
    private IFaction target;
    private boolean cancelled;


    public FactionToFactionEvent(IFPlayer triggerPlayer, IFaction sender, IFaction target) {
        this.triggerPlayer = triggerPlayer;
        this.sender = sender;
        this.target = target;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public IFPlayer getTriggerPlayer() {
        return triggerPlayer;
    }

    public IFaction getSender() {
        return sender;
    }

    public IFaction getTarget() {
        return target;
    }
}
