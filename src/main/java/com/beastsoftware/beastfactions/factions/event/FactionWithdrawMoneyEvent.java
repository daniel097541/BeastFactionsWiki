package com.beastsoftware.beastfactions.factions.event;

import com.beastsoftware.beastfactions.factions.entity.IFPlayer;
import com.beastsoftware.beastfactions.factions.entity.IFaction;

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
