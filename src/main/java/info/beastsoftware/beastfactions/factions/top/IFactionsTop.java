package info.beastsoftware.beastfactions.factions.top;

import info.beastsoftware.beastfactions.factions.entity.IFaction;
import info.beastsoftware.beastfactions.factions.entity.ITopEntity;
import info.beastsoftware.beastfactions.factions.entity.ITopEntityColl;
import org.bukkit.Chunk;
import org.bukkit.block.Block;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public interface IFactionsTop {


    HashMap<IFaction, ITopEntityColl> getSortedTop();

    void calculateTop();

    IFaction getFactionAtPos(int pos);

    long getTopValue(ITopEntity entity);

    ITopEntityColl getEntityColl(IFaction faction);

    List<ITopEntity> getEntitiesInChunk(Chunk chunk);

    void inspectEntitiesInChunkBlocks(Chunk chunk, IFaction faction);

    long getValue(Block block);

    LinkedHashMap<IFaction, ITopEntityColl> getTopPage(int from, int to);

    int getAmountOfPages(int pageSize);

    int getPositionOfFaction(IFaction faction);

}
