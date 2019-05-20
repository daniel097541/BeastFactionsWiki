package info.beastsoftware.beastfactions.factions.event;

import info.beastsoftware.beastfactions.factions.entity.IFPlayer;

public class SendMapEvent extends FPlayerAbstractEvent {

    private int size;

    public SendMapEvent(IFPlayer fPlayer, int size) {
        super(fPlayer);
        this.size = size;
    }

    public int getSize() {
        return size;
    }
}
