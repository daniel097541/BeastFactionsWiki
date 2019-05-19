package com.beastsoftware.beastfactions.factions.entity.impl;

import com.beastsoftware.beastfactions.factions.entity.IFPlayer;
import com.beastsoftware.beastfactions.factions.entity.IFaction;
import com.beastsoftware.beastfactions.factions.entity.IRelation;
import com.beastsoftware.beastfactions.factions.entity.IRelationRequest;

import java.util.Date;

public class RelationRequest implements IRelationRequest {

    private IFaction sender;
    private IFaction target;
    private Date requestDate;
    private IFPlayer playerSender;
    private IRelation requestedRelation;

    public RelationRequest(IFaction sender, IFaction target, IFPlayer playerSender, IRelation requestedRelation) {
        this.sender = sender;
        this.target = target;
        this.playerSender = playerSender;
        this.requestedRelation = requestedRelation;
        this.requestDate = new Date();
    }

    @Override
    public IFaction getSender() {
        return sender;
    }

    @Override
    public IFaction getTarget() {
        return target;
    }

    @Override
    public Date getRequestDate() {
        return (Date) requestDate.clone();
    }

    @Override
    public IFPlayer getPlayerSender() {
        return playerSender;
    }

    @Override
    public IRelation getRequestedRelation() {
        return requestedRelation;
    }
}
