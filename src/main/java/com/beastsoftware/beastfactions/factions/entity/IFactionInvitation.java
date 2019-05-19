package com.beastsoftware.beastfactions.factions.entity;

import com.beastsoftware.beastfactions.factions.entity.IFPlayer;
import com.beastsoftware.beastfactions.factions.entity.IFaction;

import java.util.Date;

public interface IFactionInvitation {

    IFPlayer getHost();

    IFPlayer getInvited();

    IFaction getFaction();

    Date invitationDate();

    int getExpireTime();
}
