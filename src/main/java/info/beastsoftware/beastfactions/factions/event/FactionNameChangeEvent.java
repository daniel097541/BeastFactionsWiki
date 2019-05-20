package info.beastsoftware.beastfactions.factions.event;

import info.beastsoftware.beastfactions.factions.entity.IFaction;

public class FactionNameChangeEvent extends SimpleFactionEvent {

    private String newName;

    public FactionNameChangeEvent(IFaction faction, String newName) {
        super(faction);
        this.newName = newName;
    }

    public String getNewName() {
        return newName;
    }
}
