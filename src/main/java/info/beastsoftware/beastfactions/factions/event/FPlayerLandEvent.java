package info.beastsoftware.beastfactions.factions.event;

import info.beastsoftware.beastfactions.factions.entity.IFPlayer;
import info.beastsoftware.beastfactions.factions.entity.IFaction;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public abstract class FPlayerLandEvent extends Event implements Cancellable {
    private static final HandlerList handlers = new HandlerList();

    private IFPlayer fPlayer;
    private IFaction faction;
    private boolean cancelled;

    public FPlayerLandEvent(IFPlayer fPlayer, IFaction faction) {
        this.fPlayer = fPlayer;
        this.faction = faction;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    public IFPlayer getfPlayer() {
        return fPlayer;
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
