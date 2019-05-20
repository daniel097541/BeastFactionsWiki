package info.beastsoftware.beastfactions.factions.defaultFactions;

import info.beastsoftware.beastfactions.factions.entity.IDefaultFaction;

import java.util.List;

public interface IDefaultFactionsManager {

    List<IDefaultFaction> getDefaultFactions();

    boolean allowsPvP(IDefaultFaction faction);

    boolean allowsCommand(IDefaultFaction faction, String command);

    boolean allowsFlight(IDefaultFaction faction);

    String getColor(IDefaultFaction faction);

    boolean isFactionless(IDefaultFaction faction);

    boolean powerLostAtDeath(IDefaultFaction faction);
}
