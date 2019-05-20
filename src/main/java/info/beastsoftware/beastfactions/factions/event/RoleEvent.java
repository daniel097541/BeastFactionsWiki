package info.beastsoftware.beastfactions.factions.event;

import info.beastsoftware.beastfactions.factions.entity.IFactionRole;

public abstract class RoleEvent extends VoidEvent {

    private final IFactionRole role;

    public RoleEvent(IFactionRole role) {
        this.role = role;
    }

    public IFactionRole getRole() {
        return role;
    }
}
