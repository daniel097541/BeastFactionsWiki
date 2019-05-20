package info.beastsoftware.beastfactions.factions.util;

import info.beastsoftware.beastfactions.BeastFactions;
import info.beastsoftware.beastfactions.factions.entity.IFPlayer;
import org.bukkit.Chunk;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ChunkUtil {

    public static List<IFPlayer> getFPlayersInChunk(Chunk chunk) {


        Stream<IFPlayer> stream = Arrays.asList(chunk.getEntities())
                .parallelStream()
                .filter(entity -> entity instanceof Player)
                .map(entity -> {
                    Player player = (Player) entity;
                    return BeastFactions.getInstance().getInternalApi().getFPlayer(player);
                });

        return stream.collect(Collectors.toList());

//
//        Entity[] entities = chunk.getEntities();
//        List<IFPlayer> players = new ArrayList<>();
//        for (Entity entity : entities) {
//            if (!(entity instanceof Player)) continue;
//            Player player = (Player) entity;
//            IFPlayer fPlayer = BeastFactions.getInstance().getInternalApi().getFPlayer(player);
//            players.add(fPlayer);
//        }
//        return players;
    }




}
