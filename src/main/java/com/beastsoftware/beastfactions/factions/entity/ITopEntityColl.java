package com.beastsoftware.beastfactions.factions.entity;

import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;

import java.io.Serializable;
import java.util.List;

public interface ITopEntityColl extends Serializable {


    long getTotalValue();

    IFaction getFaction();

    List<ITopEntity> getTopEntities();

    List<ITopEntity> getSpawnerTopEntities();

    long getSpawnersTotalValue();

    List<ITopEntity> getBlockTopEntities();

    long getBlocksTotalValue();

    List<ICashTopEntity> getCashTopEntities();

    long getCashTotalValue();

    List<ITopEntity> getAllSpawnersOfType(EntityType type);

    int getNumberOfSpawnersOfType(EntityType type);

    List<ITopEntity> getAllBlocksOfMaterial(Material material);

    void addTopEntity(ITopEntity entity);

    void addTopEntities(List<ITopEntity> entities);

    void removeTopEntitiesFromClaims(List<IClaim> chunks);

    List<ITopEntity> getEntitiesAtChunk(Chunk chunk);

    List<ITopEntity> getSpawnersAtChunk(Chunk chunk);

    ITopEntity getEntityAt(Location location);

    void removeEntitiesAtChunk(Chunk chunk);

    void removeTopEntity(ITopEntity entity);

    ITopEntityList getEntityList();

    void save();

    List<ISpawnerEntitySnapShot> getSpawnersSnapshots();

    List<IBlockEntitySnapshot> getBlocksSnapShots();

}
