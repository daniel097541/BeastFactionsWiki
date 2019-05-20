package info.beastsoftware.beastfactions.factions.event;

import info.beastsoftware.beastfactions.factions.entity.IFPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public abstract class FPlayerEvent extends Event {
    private static final HandlerList handlers = new HandlerList();

    private Player player;
    private IFPlayer fPlayer;

    public FPlayerEvent(Player player, IFPlayer fPlayer) {
        this.player = player;
        this.fPlayer = fPlayer;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    public IFPlayer getfPlayer() {
        return fPlayer;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public Player getPlayer() {
        return player;
    }
}
