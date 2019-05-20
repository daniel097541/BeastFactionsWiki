package info.beastsoftware.beastfactions.factions.event;

import info.beastsoftware.beastfactions.factions.entity.IFaction;
import info.beastsoftware.beastfactions.factions.entity.IPermission;
import info.beastsoftware.beastfactions.factions.entity.IRelation;

public class RemovePermissionFromRelationEvent extends RelationPermissionEvent {
    public RemovePermissionFromRelationEvent(IFaction faction, IPermission permission, IRelation relation) {
        super(faction, permission, relation);
    }
}
