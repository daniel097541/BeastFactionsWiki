package info.beastsoftware.beastfactions.factions.event;

import info.beastsoftware.beastfactions.factions.entity.IFPlayer;
import info.beastsoftware.beastfactions.factions.entity.IFaction;

public class CreateRoleEvent extends FPlayerAbstractEvent {


    private final IFaction faction;
    private final String prefix;
    private final String name;
    private final int priority;
    private final boolean defaultRole;


    public CreateRoleEvent(IFPlayer fPlayer, IFaction faction, String prefix, String name, int priority, boolean defaultRole) {
        super(fPlayer);
        this.faction = faction;
        this.prefix = prefix;
        this.name = name;
        this.priority = priority;
        this.defaultRole = defaultRole;
    }


    public IFaction getFaction() {
        return faction;
    }

    public String getPrefix() {
        return prefix;
    }

    public String getName() {
        return name;
    }

    public int getPriority() {
        return priority;
    }

    public boolean isDefaultRole() {
        return defaultRole;
    }
}
