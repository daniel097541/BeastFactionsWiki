package com.beastsoftware.beastfactions.factions.event;

import com.beastsoftware.beastfactions.factions.entity.IFPlayer;
import com.beastsoftware.beastfactions.factions.entity.IFaction;
import com.beastsoftware.beastfactions.factions.entity.IRelation;

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
