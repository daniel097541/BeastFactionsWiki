package info.beastsoftware.beastfactions.factions.invitation;

import info.beastsoftware.beastfactions.factions.entity.IFPlayer;
import info.beastsoftware.beastfactions.factions.entity.IFaction;

public interface IInvitationManager {

    void addInvitation(IFaction faction, IFPlayer host, IFPlayer invited, int expireTime);

    boolean isInvited(IFaction faction, IFPlayer player);

    void remove(IFaction faction, IFPlayer player);

}
