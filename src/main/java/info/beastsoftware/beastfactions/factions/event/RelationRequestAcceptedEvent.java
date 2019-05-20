package info.beastsoftware.beastfactions.factions.event;

import info.beastsoftware.beastfactions.factions.entity.IFPlayer;
import info.beastsoftware.beastfactions.factions.entity.IRelationRequest;

public class RelationRequestAcceptedEvent extends RelationRequestAbstractEvent {

    public RelationRequestAcceptedEvent(IFPlayer fPlayer, IRelationRequest relationRequest) {
        super(fPlayer, relationRequest);
    }
}
