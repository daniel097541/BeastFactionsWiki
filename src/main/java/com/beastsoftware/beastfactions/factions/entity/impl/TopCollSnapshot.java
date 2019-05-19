package com.beastsoftware.beastfactions.factions.entity.impl;

import com.beastsoftware.beastfactions.BeastFactions;
import com.beastsoftware.beastfactions.factions.entity.IBlockEntitySnapshot;
import com.beastsoftware.beastfactions.factions.entity.IFPlayer;
import com.beastsoftware.beastfactions.factions.entity.ISpawnerEntitySnapShot;
import com.beastsoftware.beastfactions.factions.entity.ITopCollSnapshot;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class TopCollSnapshot implements ITopCollSnapshot {


    private Date date;
    private UUID richestPlayer;
    private long playersMoney;
    private long totalValue;
    private List<ISpawnerEntitySnapShot> spawnerEntitySnapShots;
    private List<IBlockEntitySnapshot> blockEntitySnapshots;


    public TopCollSnapshot() {
    }

    public TopCollSnapshot(Date date, UUID richestPlayer, long totalValue, long playersMoney, List<ISpawnerEntitySnapShot> spawnerEntitySnapShots, List<IBlockEntitySnapshot> blockEntitySnapshots) {
        this.totalValue = totalValue;
        this.playersMoney = playersMoney;
        this.spawnerEntitySnapShots = spawnerEntitySnapShots;
        this.blockEntitySnapshots = blockEntitySnapshots;
        this.date = date;
    }

    @Override
    public long getTotalValue() {
        return totalValue;
    }

    @Override
    public long getSpawnersValue() {
        long total = 0L;
        for (ISpawnerEntitySnapShot spawnerEntitySnapShot : spawnerEntitySnapShots)
            total += spawnerEntitySnapShot.getValue();
        return total;
    }

    @Override
    public long getBlocksValue() {
        long total = 0L;
        for (IBlockEntitySnapshot blockEntitySnapshot : blockEntitySnapshots)
            total += blockEntitySnapshot.getValue();
        return total;
    }

    @Override
    public long getPlayersMoneyValue() {
        return playersMoney;
    }

    @Override
    public List<ISpawnerEntitySnapShot> getSpawnersSnapshot() {
        return spawnerEntitySnapShots;
    }

    @Override
    public List<IBlockEntitySnapshot> getBlocksEntitySnapshot() {
        return blockEntitySnapshots;
    }

    @Override
    public Date getDate() {
        return date;
    }

    @Override
    public int getAllBlocksOfMaterial(Material material) {

        int count = 0;
        for(IBlockEntitySnapshot blockEntitySnapshot : getBlocksEntitySnapshot()){
            if(blockEntitySnapshot.getMaterial().equals(material))
                count++;
        }

        return count;
    }

    @Override
    public int getNumberOfSpawnersOfType(EntityType entityType) {

        int count = 0;

        for (ISpawnerEntitySnapShot spawnerEntitySnapShot : getSpawnersSnapshot()){
            if(spawnerEntitySnapShot.getType().equals(entityType))
                count += spawnerEntitySnapShot.getAmount();
        }
        return count;
    }

    @Override
    public IFPlayer getRichestPlayer() {
        return BeastFactions.getInstance().getInternalApi().getFPlayer(richestPlayer);
    }
}
