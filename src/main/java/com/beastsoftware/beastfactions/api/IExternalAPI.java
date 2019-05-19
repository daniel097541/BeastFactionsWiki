package com.beastsoftware.beastfactions.api;

import com.beastsoftware.beastfactions.factions.entity.IDefaultFaction;
import com.beastsoftware.beastfactions.factions.entity.IFPlayer;
import com.beastsoftware.beastfactions.factions.entity.IFaction;
import com.beastsoftware.beastfactions.factions.top.IFactionsTop;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.UUID;

public interface IExternalAPI {


    ///////// FPLAYER
    IFPlayer getPlayer(Player player);

    IFPlayer getPlayer(String name);

    IFPlayer getPlayer(UUID uuid);


    //////// FACTION
    IFaction getFaction(String name);

    IFaction getFaction(long id);

    IFaction getFactionAt(Location location);

    IFaction asyncGetFactionAt(Chunk chunk);

    IFaction getFactionAt(Chunk chunk);

    List<IDefaultFaction> getDefaultFactions();

    IDefaultFaction getFactionlessFaction();


    //////// FACTION SETTERS
    void claimForFaction(IFaction faction, Chunk chunk);

    void claimForFaction(IFaction faction, Location location);

    void asyncClaimForFaction(IFaction faction, Chunk chunk);

    /////// TOP
    IFactionsTop getTop();

}
