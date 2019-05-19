package com.beastsoftware.beastfactions.factions.entity;

import java.util.Date;

public interface IRelationRequest {


    IFaction getSender();

    IFaction getTarget();

    IRelation getRequestedRelation();

    Date getRequestDate();

    IFPlayer getPlayerSender();

}
