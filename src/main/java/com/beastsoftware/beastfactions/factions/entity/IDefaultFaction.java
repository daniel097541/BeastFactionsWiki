package com.beastsoftware.beastfactions.factions.entity;

public interface IDefaultFaction extends IFaction {


    boolean allowsPvP();

    boolean allowsFly();

    boolean allowsCommand(String command);

    boolean isFactionlessFaction();

    boolean powerLostAtDeath();

}
