package com.beastsoftware.beastfactions.factions.event;

import com.beastsoftware.beastfactions.factions.entity.IFPlayer;
import com.beastsoftware.beastfactions.factions.entity.IFaction;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public abstract class InvitationEvent extends Event {
    private static final HandlerList handlers = new HandlerList();

    private IFPlayer invited;
    private IFPlayer sender;
    private IFaction faction;

    public InvitationEvent(IFPlayer invited, IFPlayer sender, IFaction faction) {
        this.invited = invited;
        this.sender = sender;
        this.faction = faction;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    public IFPlayer getInvited() {
        return invited;
    }

    public IFPlayer getSender() {
        return sender;
    }

    public IFaction getFaction() {
        return faction;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }
}
