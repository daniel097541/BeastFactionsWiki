package com.beastsoftware.beastfactions.factions.event;

import com.beastsoftware.beastfactions.factions.entity.IFPlayer;
import com.beastsoftware.beastfactions.factions.entity.IRelationRequest;

public class RelationRequestDeniedEvent extends RelationRequestAbstractEvent {

    public RelationRequestDeniedEvent(IFPlayer fPlayer, IRelationRequest relationRequest) {
        super(fPlayer, relationRequest);
    }
}
