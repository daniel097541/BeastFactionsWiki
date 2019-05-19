package com.beastsoftware.beastfactions.factions.event;


import com.beastsoftware.beastfactions.factions.entity.IFPlayer;
import com.beastsoftware.beastfactions.factions.entity.IFaction;

public class InvitationCancelledEvent extends InvitationEvent {

    public InvitationCancelledEvent(IFPlayer invited, IFPlayer sender, IFaction faction) {
        super(invited, sender, faction);
    }
}
