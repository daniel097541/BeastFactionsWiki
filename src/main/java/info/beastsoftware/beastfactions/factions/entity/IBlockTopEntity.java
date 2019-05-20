package info.beastsoftware.beastfactions.factions.entity;


import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;

public interface IBlockTopEntity extends ITopEntity {

    Block getBlock();

    Location getLocation();

    Material getMaterial();

}
