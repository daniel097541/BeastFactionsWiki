package com.beastsoftware.beastfactions.factions.entity;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;

import java.util.Date;
import java.util.List;

public interface ITopCollSnapshot {

    long getTotalValue();

    long getSpawnersValue();

    long getBlocksValue();

    long getPlayersMoneyValue();

    List<ISpawnerEntitySnapShot> getSpawnersSnapshot();

    List<IBlockEntitySnapshot> getBlocksEntitySnapshot();

    Date getDate();

    int getAllBlocksOfMaterial(Material material);

    int getNumberOfSpawnersOfType(EntityType entityType);

    IFPlayer getRichestPlayer();
}
