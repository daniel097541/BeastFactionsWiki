package info.beastsoftware.beastfactions.factions.event;

import info.beastsoftware.beastfactions.factions.entity.IFaction;
import info.beastsoftware.beastfactions.factions.entity.IPermission;
import info.beastsoftware.beastfactions.factions.entity.IRelation;

public class AddPermissionToRelationEvent extends RelationPermissionEvent {

    public AddPermissionToRelationEvent(IFaction faction, IPermission permission, IRelation relation) {
        super(faction, permission, relation);
    }
}
