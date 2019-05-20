package info.beastsoftware.beastfactions.factions.entity.impl;

import info.beastsoftware.beastfactions.factions.entity.IFPlayer;
import info.beastsoftware.beastfactions.factions.entity.IFaction;
import info.beastsoftware.beastfactions.factions.entity.IFactionInvitation;

import java.util.Date;

public class FactionInvitation implements IFactionInvitation {

    private IFPlayer host;
    private IFPlayer invited;
    private IFaction faction;
    private Date date;
    private int expireTime;

    public FactionInvitation(IFPlayer host, IFPlayer invited, IFaction faction, int expireTime) {
        this.host = host;
        this.invited = invited;
        this.faction = faction;
        this.expireTime = expireTime;
        this.date = new Date();
    }

    @Override
    public IFPlayer getHost() {
        return host;
    }

    @Override
    public IFPlayer getInvited() {
        return invited;
    }

    @Override
    public IFaction getFaction() {
        return faction;
    }

    @Override
    public Date invitationDate() {
        return (Date) date.clone();
    }

    @Override
    public int getExpireTime() {
        return expireTime;
    }
}
