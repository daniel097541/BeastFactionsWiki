package info.beastsoftware.beastfactions.factions.event;

import info.beastsoftware.beastfactions.factions.entity.IFPlayer;
import info.beastsoftware.beastfactions.factions.entity.IRelationRequest;

public class RelationRequestDeniedEvent extends RelationRequestAbstractEvent {

    public RelationRequestDeniedEvent(IFPlayer fPlayer, IRelationRequest relationRequest) {
        super(fPlayer, relationRequest);
    }
}
