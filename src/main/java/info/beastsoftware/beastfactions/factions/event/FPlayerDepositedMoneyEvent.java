package info.beastsoftware.beastfactions.factions.event;

import info.beastsoftware.beastfactions.factions.entity.IFPlayer;
import info.beastsoftware.beastfactions.factions.entity.IFaction;

public class FPlayerDepositedMoneyEvent extends FPlayerAbstractEvent {

    private final IFaction faction;
    private final long money;

    public FPlayerDepositedMoneyEvent(IFPlayer fPlayer, IFaction faction, long money) {
        super(fPlayer);
        this.faction = faction;
        this.money = money;
    }

    public IFaction getFaction() {
        return faction;
    }

    public long getMoney() {
        return money;
    }
}
