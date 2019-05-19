package com.beastsoftware.beastfactions.factions.event;

import com.beastsoftware.beastfactions.factions.entity.IFPlayer;
import com.beastsoftware.beastfactions.factions.entity.IFaction;
import com.beastsoftware.beastfactions.factions.entity.IRelation;

public class RelationChangeEvent extends FactionToFactionEvent {

    private IRelation relation;


    public RelationChangeEvent(IFPlayer triggerPlayer, IFaction sender, IFaction target, IRelation relation) {
        super(triggerPlayer, sender, target);
        this.relation = relation;
    }

    public IRelation getRelation() {
        return relation;
    }
}
