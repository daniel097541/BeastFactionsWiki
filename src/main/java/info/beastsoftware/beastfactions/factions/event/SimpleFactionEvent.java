package info.beastsoftware.beastfactions.factions.event;

import info.beastsoftware.beastfactions.factions.entity.IFaction;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public abstract class SimpleFactionEvent extends Event implements Cancellable {
    private static final HandlerList handlers = new HandlerList();

    protected IFaction faction;
    private boolean cancelled;

    public SimpleFactionEvent(IFaction faction) {
        this.faction = faction;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    public IFaction getFaction() {
        return faction;
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

}
