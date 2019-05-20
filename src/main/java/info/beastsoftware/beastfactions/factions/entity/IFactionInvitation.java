package info.beastsoftware.beastfactions.factions.entity;

import java.util.Date;

public interface IFactionInvitation {

    IFPlayer getHost();

    IFPlayer getInvited();

    IFaction getFaction();

    Date invitationDate();

    int getExpireTime();
}
