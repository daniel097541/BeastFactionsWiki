package info.beastsoftware.beastfactions.factions.entity;

import org.bukkit.Chunk;
import org.bukkit.World;

import java.io.Serializable;
import java.util.UUID;

public interface IFChunk extends Serializable {


    int getX();

    int getZ();

    String getWorldName();

    World getWorld();

    Chunk getChunk();

    boolean canBeClaimedByFaction(IFaction faction, IFPlayer player);

    IFaction getFactionAt();

    UUID getServerName();

    boolean isClaimed();

    void clearClaim();
}
