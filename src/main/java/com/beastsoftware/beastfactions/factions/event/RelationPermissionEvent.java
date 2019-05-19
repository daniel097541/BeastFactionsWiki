package com.beastsoftware.beastfactions.factions.event;

import com.beastsoftware.beastfactions.factions.entity.IFaction;
import com.beastsoftware.beastfactions.factions.entity.IPermission;
import com.beastsoftware.beastfactions.factions.entity.IRelation;

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
