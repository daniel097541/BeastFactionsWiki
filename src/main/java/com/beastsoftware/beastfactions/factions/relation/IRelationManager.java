package com.beastsoftware.beastfactions.factions.relation;

import com.beastsoftware.beastfactions.factions.entity.IFaction;
import com.beastsoftware.beastfactions.factions.entity.IRelation;
import com.beastsoftware.beastfactions.factions.entity.IRelationRequest;

import java.util.HashMap;
import java.util.List;

public interface IRelationManager {
    IRelation getDefaultRelation();

    void loadRelations();

    List<IRelation> getRelations();

    IRelation getByName(String name);

    HashMap<String, List<Long>> serializeRelations();

    void addRelationRequest(IRelationRequest relationRequest);

    void removeRelationRequest(IFaction sender, IFaction target);

    IRelationRequest getRelationRequest(IFaction sender, IFaction target);

    boolean requestExists(IFaction sender, IFaction target);

    IRelation getOwnRelation();

}
