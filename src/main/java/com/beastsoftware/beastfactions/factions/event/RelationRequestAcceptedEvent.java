package com.beastsoftware.beastfactions.factions.event;

import com.beastsoftware.beastfactions.factions.entity.IFPlayer;
import com.beastsoftware.beastfactions.factions.entity.IRelationRequest;

public class RelationRequestAcceptedEvent extends RelationRequestAbstractEvent {

    public RelationRequestAcceptedEvent(IFPlayer fPlayer, IRelationRequest relationRequest) {
        super(fPlayer, relationRequest);
    }
}
