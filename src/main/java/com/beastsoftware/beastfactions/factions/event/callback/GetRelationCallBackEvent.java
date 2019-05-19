package com.beastsoftware.beastfactions.factions.event.callback;

import com.beastsoftware.beastfactions.factions.entity.IRelation;

public class GetRelationCallBackEvent extends CallBackEvent {

    private boolean defRelation;
    private String name;
    private IRelation relation;


    public GetRelationCallBackEvent(boolean defRelation) {
        this.defRelation = defRelation;
    }

    public GetRelationCallBackEvent(String name) {
        this.name = name;
    }

    public IRelation getRelation() {
        return relation;
    }

    public void setRelation(IRelation relation) {
        this.relation = relation;
    }

    public boolean isDefRelation() {
        return defRelation;
    }

    public String getName() {
        return name;
    }
}
