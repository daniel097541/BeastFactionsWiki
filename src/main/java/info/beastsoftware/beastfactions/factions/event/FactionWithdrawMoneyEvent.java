package info.beastsoftware.beastfactions.factions.event;

import info.beastsoftware.beastfactions.factions.entity.IFPlayer;
import info.beastsoftware.beastfactions.factions.entity.IFaction;

public class FactionWithdrawMoneyEvent extends FPlayerAbstractEvent {

    private final IFaction faction;
    private final long amount;

    public FactionWithdrawMoneyEvent(IFPlayer fPlayer, IFaction faction, long amount) {
        super(fPlayer);
        this.faction = faction;
        this.amount = amount;
    }


    public IFaction getFaction() {
        return faction;
    }

    public long getAmount() {
        return amount;
    }
}
