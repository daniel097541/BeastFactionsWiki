package com.beastsoftware.beastfactions.factions.entity.impl;

import com.beastsoftware.beastfactions.BeastFactions;
import com.beastsoftware.beastfactions.factions.entity.IDefaultFaction;

public class DefaultFaction extends Faction implements IDefaultFaction {

    public DefaultFaction() {
        super();
    }

    public DefaultFaction(String name, long id) {
        super(name, id);
    }

    @Override
    public boolean allowsPvP() {
        return BeastFactions.getInstance().getInternalApi().getDefaultFactionsManager().allowsPvP(this);
    }

    @Override
    public boolean allowsFly() {
        return BeastFactions.getInstance().getInternalApi().getDefaultFactionsManager().allowsFlight(this);
    }

    @Override
    public boolean allowsCommand(String command) {
        return BeastFactions.getInstance().getInternalApi().getDefaultFactionsManager().allowsCommand(this, command);
    }

    @Override
    public boolean isFactionlessFaction() {
        return BeastFactions.getInstance().getInternalApi().getDefaultFactionsManager().isFactionless(this);
    }

    @Override
    public boolean powerLostAtDeath() {
        return BeastFactions.getInstance().getInternalApi().getDefaultFactionsManager().powerLostAtDeath(this);
    }

    @Override
    public String getColor() {
        return BeastFactions.getInstance().getInternalApi().getDefaultFactionsManager().getColor(this);
    }

    @Override
    public boolean isFactionless() {
        return BeastFactions.getInstance().getInternalApi().getDefaultFactionsManager().isFactionless(this);
    }
}
