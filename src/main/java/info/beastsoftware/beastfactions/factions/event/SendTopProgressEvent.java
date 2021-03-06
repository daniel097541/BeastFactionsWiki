package info.beastsoftware.beastfactions.factions.event;

import info.beastsoftware.beastfactions.factions.entity.IFPlayer;
import info.beastsoftware.beastfactions.factions.entity.IFaction;

public class SendTopProgressEvent extends FPlayerAbstractEvent {

    private final int record;
    private final IFaction faction;

    public SendTopProgressEvent(IFPlayer fPlayer, int record, IFaction faction) {
        super(fPlayer);
        this.record = record;
        this.faction = faction;
    }

    public IFaction getFaction() {
        return faction;
    }

    public int getRecord() {
        return record;
    }
}
