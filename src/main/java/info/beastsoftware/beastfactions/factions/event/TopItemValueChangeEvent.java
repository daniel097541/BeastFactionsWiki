package info.beastsoftware.beastfactions.factions.event;


import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public abstract class TopItemValueChangeEvent extends Event {
    private static final HandlerList handlers = new HandlerList();
    private long price;


    public TopItemValueChangeEvent(long price) {
        this.price = price;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    public long getPrice() {
        return price;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

}
