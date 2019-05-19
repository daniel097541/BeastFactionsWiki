package com.beastsoftware.beastfactions.factions.event;

import com.beastsoftware.beastfactions.factions.entity.IFPlayer;
import com.beastsoftware.beastfactions.factions.entity.IFaction;

public class InvitationSentEvent extends InvitationEvent {
    private int expireTime;

    public InvitationSentEvent(IFPlayer invited, IFPlayer sender, IFaction faction, int expireTime) {
        super(invited, sender, faction);
        this.expireTime = expireTime;
    }

    public int getExpireTime() {
        return expireTime;
    }
}
