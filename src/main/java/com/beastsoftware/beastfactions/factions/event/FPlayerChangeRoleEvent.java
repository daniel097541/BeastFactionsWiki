package com.beastsoftware.beastfactions.factions.event;

import com.beastsoftware.beastfactions.factions.entity.IFPlayer;
import com.beastsoftware.beastfactions.factions.entity.IFactionRole;

public class FPlayerChangeRoleEvent extends FPlayerAbstractEvent {

    private IFPlayer changer;
    private IFactionRole newRole;

    public FPlayerChangeRoleEvent(IFPlayer fPlayer, IFPlayer changer, IFactionRole newRole) {
        super(fPlayer);
        this.changer = changer;
        this.newRole = newRole;
    }

    public IFPlayer getChanger() {
        return changer;
    }

    public IFactionRole getNewRole() {
        return newRole;
    }
}
