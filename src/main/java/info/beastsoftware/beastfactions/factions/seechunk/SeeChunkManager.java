package info.beastsoftware.beastfactions.factions.seechunk;

import info.beastsoftware.beastfactions.BeastFactions;
import info.beastsoftware.beastfactions.factions.entity.IFPlayer;
import info.beastsoftware.beastfactions.manager.IManager;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.block.BlockFace;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


@Singleton
public class SeeChunkManager implements IManager<IFPlayer> {


    private volatile HashMap<UUID, IFPlayer> players;
    private volatile HashMap<UUID, Integer> tasks;
    private BeastFactions plugin;

    @Inject
    public SeeChunkManager(BeastFactions plugin) {
        this.players = new HashMap<>();
        this.tasks = new HashMap<>();
        this.plugin = plugin;
    }

    @Override
    public void add(IFPlayer object) {
        players.put(object.getUuid(), object);

        int task = Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, () -> {

            if (!object.isOnline()) return;

            Location playersLoc = object.getLocation().getLocation();
            int y = playersLoc.getBlockY();
            Chunk chunk = playersLoc.getChunk();

            for (int i = y - 20; i < y + 20; i++) {

                Location corner1 = chunk.getBlock(15, i, 15).getLocation();
                Location corner2 = chunk.getBlock(0, i, 15).getLocation();
                Location corner3 = chunk.getBlock(0, i, 0).getLocation();
                Location corner4 = chunk.getBlock(15, i, 0).getLocation();

                //play effect
                object.getPlayer().playEffect(corner1, Effect.SMOKE, BlockFace.NORTH_WEST);
                object.getPlayer().playEffect(corner2, Effect.SMOKE, BlockFace.NORTH_EAST);
                object.getPlayer().playEffect(corner3, Effect.SMOKE, BlockFace.SOUTH_EAST);
                object.getPlayer().playEffect(corner4, Effect.SMOKE, BlockFace.SOUTH_WEST);

            }


        }, 0L, 1L);

        tasks.put(object.getUuid(), task);
    }

    @Override
    public void remove(IFPlayer object) {
        int task = tasks.get(object.getUuid());

        Bukkit.getScheduler().cancelTask(task);

        tasks.remove(object.getUuid());
        players.remove(object.getUuid());
    }

    @Override
    public boolean isPresent(IFPlayer object) {
        return players.containsKey(object.getUuid());
    }

    @Override
    public void removeAll() {
        players.clear();
        for (Map.Entry<UUID, Integer> entry : tasks.entrySet()) {
            int task = entry.getValue();
            Bukkit.getScheduler().cancelTask(task);
        }
        tasks.clear();
    }
}
