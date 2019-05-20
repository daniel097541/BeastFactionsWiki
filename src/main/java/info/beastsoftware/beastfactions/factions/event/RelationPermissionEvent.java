package info.beastsoftware.beastfactions.factions.event;

import info.beastsoftware.beastfactions.factions.entity.IFaction;
import info.beastsoftware.beastfactions.factions.entity.IPermission;
import info.beastsoftware.beastfactions.factions.entity.IRelation;

public class RelationPermissionEvent extends PermissionEvent {

    private final IRelation relation;

    public RelationPermissionEvent(IFaction faction, IPermission permission, IRelation relation) {
        super(faction, permission);
        this.relation = relation;
    }


    public IRelation getRelation() {
        return relation;
    }
}
