package info.beastsoftware.beastfactions.factions.event;

import info.beastsoftware.beastfactions.factions.entity.IFPlayer;
import info.beastsoftware.beastfactions.factions.entity.IRelationRequest;

public abstract class RelationRequestAbstractEvent extends FPlayerAbstractEvent {
    private IRelationRequest relationRequest;

    public RelationRequestAbstractEvent(IFPlayer fPlayer, IRelationRequest relationRequest) {
        super(fPlayer);
        this.relationRequest = relationRequest;
    }

    public IRelationRequest getRelationRequest() {
        return relationRequest;
    }
}
