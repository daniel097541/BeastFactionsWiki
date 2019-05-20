package info.beastsoftware.beastfactions.hook;

import org.bukkit.Location;
import org.bukkit.entity.EntityType;

public interface IEpicSpawnersHook {


    boolean isSpawner(Location location);

    int amountStacked(Location location);

    EntityType getType(Location location);

}
