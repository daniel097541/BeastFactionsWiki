package com.beastsoftware.beastfactions.factions.entity;

import org.bukkit.Chunk;
import org.bukkit.World;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public interface IClaim extends Serializable {
    IFaction getFaction();

    IFPlayer getClaimer();

    Chunk getChunk();

    IFChunk getFChunk();

    World getWorld();

    long getFactionId();

    Date getClaimDate();

    String getServerName();

    void setServerName(String serverName);

    int getX();

    int getZ();

    String getWorldName();

    List<IFPlayer> getPlayersInside();

    List<IFactionWarp> getWarpsInside();
}
