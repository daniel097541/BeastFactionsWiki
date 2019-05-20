package info.beastsoftware.beastfactions.factions.top;

import info.beastsoftware.beastfactions.factions.entity.ITopEntity;
import org.bukkit.Chunk;
import org.bukkit.block.Block;

import java.util.List;

public interface ITopManager {
    long getValue(ITopEntity entity);

    List<ITopEntity> getEntitiesInChunk(Chunk chunk);

    long getValue(Block block);

}
