package info.beastsoftware.beastfactions.factions.event;

import info.beastsoftware.beastfactions.factions.entity.IFPlayer;
import info.beastsoftware.beastfactions.factions.entity.IFaction;

public class InvitationAcceptedEvent extends InvitationEvent {
    public InvitationAcceptedEvent(IFPlayer invited, IFPlayer sender, IFaction faction) {
        super(invited, sender, faction);
    }
}
