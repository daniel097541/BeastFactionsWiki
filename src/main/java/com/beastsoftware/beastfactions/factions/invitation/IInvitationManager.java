package com.beastsoftware.beastfactions.factions.invitation;

import com.beastsoftware.beastfactions.factions.entity.IFPlayer;
import com.beastsoftware.beastfactions.factions.entity.IFaction;

public interface IInvitationManager {

    void addInvitation(IFaction faction, IFPlayer host, IFPlayer invited, int expireTime);

    boolean isInvited(IFaction faction, IFPlayer player);

    void remove(IFaction faction, IFPlayer player);

}
