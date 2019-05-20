package info.beastsoftware.beastfactions.factions.event;

import info.beastsoftware.beastfactions.factions.entity.IFPlayer;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public abstract class FPlayerAbstractEvent extends Event implements Cancellable {


    private static final HandlerList handlers = new HandlerList();

    private IFPlayer fPlayer;
    private boolean cancelled;

    public FPlayerAbstractEvent(IFPlayer fPlayer) {
        this.fPlayer = fPlayer;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    public IFPlayer getfPlayer() {
        return fPlayer;
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
