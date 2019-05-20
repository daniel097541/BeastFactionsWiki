package info.beastsoftware.beastfactions.factions.event;

import info.beastsoftware.beastfactions.factions.entity.IFaction;
import info.beastsoftware.beastfactions.factions.entity.ITopEntityColl;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public abstract class TopEntityCollEvent extends Event {
    private static final HandlerList handlers = new HandlerList();
    private ITopEntityColl topEntityColl;


    public TopEntityCollEvent(ITopEntityColl topEntityColl) {
        this.topEntityColl = topEntityColl;
    }

    public ITopEntityColl getTopEntityColl() {
        return topEntityColl;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public IFaction getFaction(){
        return topEntityColl.getFaction();
    }

}
