package com.beastsoftware.beastfactions.factions.event;

import com.beastsoftware.beastfactions.factions.entity.IFaction;
import com.beastsoftware.beastfactions.factions.entity.IPermission;
import com.beastsoftware.beastfactions.factions.entity.IRelation;

public class RemovePermissionFromRelationEvent extends RelationPermissionEvent {
    public RemovePermissionFromRelationEvent(IFaction faction, IPermission permission, IRelation relation) {
        super(faction, permission, relation);
    }
}
