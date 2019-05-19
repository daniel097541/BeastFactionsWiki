package com.beastsoftware.beastfactions.factions.entity.impl;

import com.beastsoftware.beastfactions.factions.entity.IMoneySnapshot;

public class MoneySnapshot implements IMoneySnapshot {

    private long value;

    public MoneySnapshot(long value) {
        this.value = value;
    }

    @Override
    public long getValue() {
        return value;
    }
}
