package info.beastsoftware.beastfactions.factions.event;

import info.beastsoftware.beastfactions.factions.entity.IFPlayer;
import info.beastsoftware.beastfactions.factions.entity.IFaction;
import info.beastsoftware.beastfactions.factions.entity.IRelation;

public class RelationRequestEvent extends FactionToFactionEvent {

    private IRelation requestedRelation;

    public RelationRequestEvent(IFPlayer triggerPlayer, IFaction sender, IFaction target, IRelation requestedRelation) {
        super(triggerPlayer, sender, target);
        this.requestedRelation = requestedRelation;
    }

    public IRelation getRequestedRelation() {
        return requestedRelation;
    }
}
