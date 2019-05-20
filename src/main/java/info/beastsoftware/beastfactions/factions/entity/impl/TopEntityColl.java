package info.beastsoftware.beastfactions.factions.entity.impl;

import info.beastsoftware.beastfactions.BeastFactions;
import com.beastsoftware.beastfactions.factions.entity.*;
import info.beastsoftware.beastfactions.factions.entity.*;
import info.beastsoftware.beastfactions.factions.event.TopEntityCollSaveEvent;
import info.beastsoftware.beastfactions.factions.event.callback.GetTopEntityCollValueCallbackEvent;
import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TopEntityColl implements ITopEntityColl {

    private ITopEntityList topEntities;
    private long factionId;


    public TopEntityColl(List<ITopEntity> topEntities, long factionId) {
        this.topEntities = new TopEntityList(topEntities);
        this.factionId = factionId;
    }


    @Override
    public long getTotalValue() {

        long value;

        GetTopEntityCollValueCallbackEvent event = new GetTopEntityCollValueCallbackEvent(this);
        Bukkit.getPluginManager().callEvent(event);

        value = (long) event.getValue();
        return value;
    }

    @Override
    public IFaction getFaction() {
        return BeastFactions.getInstance().getInternalApi().getFactionFromId(factionId);
    }


    @Override
    public List<ITopEntity> getTopEntities() {
        return topEntities.getList();
    }


    @Override
    public List<ITopEntity> getSpawnerTopEntities() {
        List<ITopEntity> spawnerTopEntities = new ArrayList<>();
        for (ITopEntity entity : getTopEntities())
            if (entity instanceof ISpawnerTopEntity)
                spawnerTopEntities.add(entity);

        return spawnerTopEntities;
    }

    @Override
    public long getSpawnersTotalValue() {
        return getTotalValue(getSpawnerTopEntities());
    }

    private long getTotalValue(List<ITopEntity> entities) {
        long value = 0L;

        for (ITopEntity entity : entities)
            value += entity.getValue();

        return value;
    }

    @Override
    public List<ITopEntity> getBlockTopEntities() {
        List<ITopEntity> blockTopEntities = new ArrayList<>();
        for (ITopEntity entity : getTopEntities())
            if (entity instanceof IBlockTopEntity && !(entity instanceof ISpawnerTopEntity))
                blockTopEntities.add(entity);

        return blockTopEntities;
    }

    @Override
    public long getBlocksTotalValue() {
        return getTotalValue(getBlockTopEntities());
    }

    @Override
    public List<ICashTopEntity> getCashTopEntities() {
        List<ICashTopEntity> cashTopEntities = new ArrayList<>();

        for (IFPlayer player : getFaction().getFPlayers()) {
            ICashTopEntity cashTopEntity = new CashTopEntity(player, (long) player.getMoney());
            cashTopEntities.add(cashTopEntity);
        }

        return cashTopEntities;
    }

    @Override
    public long getCashTotalValue() {
        return 0;
    }

    @Override
    public List<ITopEntity> getAllSpawnersOfType(EntityType type) {

        List<ITopEntity> entities = new ArrayList<>();

        for (ITopEntity entity : getSpawnerTopEntities()) {
            ISpawnerTopEntity spawnerTopEntity = (ISpawnerTopEntity) entity;
            if (spawnerTopEntity.getType().equalsIgnoreCase(type.toString()))
                entities.add(spawnerTopEntity);
        }

        return entities;
    }

    @Override
    public int getNumberOfSpawnersOfType(EntityType type) {

        int amount = 0;

        for (ITopEntity entity : getAllSpawnersOfType(type)) {
            ISpawnerTopEntity spawnerTopEntity = (ISpawnerTopEntity) entity;
            amount += spawnerTopEntity.getAmountStacked();
        }

        return amount;
    }

    @Override
    public List<ITopEntity> getAllBlocksOfMaterial(Material material) {
        List<ITopEntity> entities = new ArrayList<>();

        for (ITopEntity entity : getBlockTopEntities()) {
            IBlockTopEntity blockTopEntity = (IBlockTopEntity) entity;
            if (material.equals(((IBlockTopEntity) entity).getMaterial()))
                entities.add(blockTopEntity);
        }

        return entities;
    }

    @Override
    public void addTopEntity(ITopEntity entity) {
        topEntities.add(entity);
    }

    @Override
    public void addTopEntities(List<ITopEntity> entities) {
        for(ITopEntity entity : entities)
            addTopEntity(entity);
    }

    @Override
    public void removeTopEntitiesFromClaims(List<IClaim> chunks) {
        for (IClaim chunk : chunks)
            removeEntitiesAtChunk(chunk.getChunk());
    }

    @Override
    public List<ITopEntity> getEntitiesAtChunk(Chunk chunk) {
        List<ITopEntity> entities = new ArrayList<>();
        for (ITopEntity be : getBlockTopEntities()) {
            IBlockTopEntity be2 = (IBlockTopEntity) be;
            if (be2.getLocation().getChunk().equals(chunk))
                entities.add(be);
        }
        return entities;
    }

    @Override
    public List<ITopEntity> getSpawnersAtChunk(Chunk chunk) {
        List<ITopEntity> entities = new ArrayList<>();

        for (ITopEntity be : getSpawnerTopEntities()) {
            ISpawnerTopEntity be2 = (ISpawnerTopEntity) be;
            if (be2.getLocation().getChunk().equals(chunk))
                entities.add(be);
        }
        return entities;
    }


    @Override
    public ITopEntity getEntityAt(Location location) {

        //look for block entities
        for (ITopEntity entity : getEntitiesAtChunk(location.getChunk())) {
            if (((IBlockTopEntity) entity).getLocation().equals(location))
                return entity;
        }

        //look for spawner entities
        for (ITopEntity entity : getSpawnersAtChunk(location.getChunk())) {
            if (((ISpawnerTopEntity) entity).getLocation().equals(location))
                return entity;
        }

        return null;
    }

    @Override
    public void removeEntitiesAtChunk(Chunk chunk) {
        //remove blocks
        for (ITopEntity entity : getEntitiesAtChunk(chunk))
            removeTopEntity(entity);

        //remove spawners
        for (ITopEntity entity : getSpawnersAtChunk(chunk))
            removeTopEntity(entity);
    }

    @Override
    public void removeTopEntity(ITopEntity entity) {
        topEntities.remove(entity);
    }

    @Override
    public ITopEntityList getEntityList() {
        return topEntities;
    }

    @Override
    public void save() {
        Bukkit.getPluginManager().callEvent(new TopEntityCollSaveEvent(this));
    }

    @Override
    public List<ISpawnerEntitySnapShot> getSpawnersSnapshots() {

        List<ISpawnerEntitySnapShot> spawnerEntitySnapShots = new ArrayList<>();


        for(ITopEntity entity : this.getSpawnerTopEntities()){

            ISpawnerTopEntity spawnerTopEntity = (ISpawnerTopEntity) entity;
            int amount = 1;
            if(BeastFactions.getInstance().getInternalApi().isHookedIntoEpicSpawners())
                amount = BeastFactions.getInstance().getInternalApi().getAmountOfSpawnersStacked(spawnerTopEntity.getLocation());

            ISpawnerEntitySnapShot snapShot = new SpawnerEntitySnapshot(amount, spawnerTopEntity.getValue() * amount, spawnerTopEntity.getType());
            spawnerEntitySnapShots.add(snapShot);
        }


        return spawnerEntitySnapShots;
    }

    @Override
    public List<IBlockEntitySnapshot> getBlocksSnapShots() {

        List<IBlockEntitySnapshot> snapshots = new ArrayList<>();


        for(ITopEntity entity : this.getBlockTopEntities()){

            IBlockTopEntity blockTopEntity = (IBlockTopEntity) entity;


            IBlockEntitySnapshot snapShot = new BlockEntitySnapshot(blockTopEntity.getValue(), blockTopEntity.getMaterial().toString());
            snapshots.add(snapShot);
        }


        return snapshots;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TopEntityColl that = (TopEntityColl) o;
        return factionId == that.factionId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(factionId);
    }
}
