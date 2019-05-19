package com.beastsoftware.beastfactions.factions.event;


import com.beastsoftware.beastfactions.factions.entity.IFaction;
import com.beastsoftware.beastfactions.factions.entity.ITopEntity;
import org.bukkit.Chunk;

import java.util.List;

public class InspectionFinishedEvent extends SimpleFactionEvent {

    private Chunk chunk;
    private IFaction faction;
    private List<ITopEntity> entityList;

    public InspectionFinishedEvent(IFaction faction, Chunk chunk, List<ITopEntity> entityList) {
        super(faction);
        this.chunk = chunk;
        this.faction = faction;
        this.entityList = entityList;
    }

    public Chunk getChunk() {
        return chunk;
    }

    public IFaction getFaction() {
        return faction;
    }

    public List<ITopEntity> getEntityList() {
        return entityList;
    }
}
