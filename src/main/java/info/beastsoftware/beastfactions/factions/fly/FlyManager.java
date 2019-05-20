package info.beastsoftware.beastfactions.factions.fly;

import info.beastsoftware.beastfactions.factions.entity.IFPlayer;
import info.beastsoftware.beastfactions.manager.IManager;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Iterator;
import java.util.UUID;

@Singleton
public class FlyManager implements IManager<IFPlayer> {


    private volatile HashMap<UUID, IFPlayer> flying;


    @Inject
    public FlyManager() {
        this.flying = new HashMap<>();
    }


    @Override
    public void add(IFPlayer ifPlayer) {
        Player player = ifPlayer.getPlayer();

        if (player == null) return;

        /////////// toggle on fly mode
        player.setAllowFlight(true);
        player.setFlying(true);
        flying.put(ifPlayer.getUuid(), ifPlayer);
    }

    @Override
    public void remove(IFPlayer ifPlayer) {
        Player player = ifPlayer.getPlayer();

        if (player == null) return;

        /////////// toggle off fly mode
        player.setAllowFlight(false);
        player.setFlying(false);
        flying.remove(ifPlayer.getUuid());

    }



    @Override
    public boolean isPresent(IFPlayer object) {
        return flying.containsKey(object.getUuid());
    }

    @Override
    public void removeAll() {
        for (Iterator<IFPlayer> iterator = flying.values().iterator(); iterator.hasNext(); ) {
            IFPlayer ifPlayer = iterator.next();
            if (ifPlayer.getPlayer() != null) {
                ifPlayer.getPlayer().setAllowFlight(false);
                ifPlayer.getPlayer().setFlying(false);
            }
            iterator.remove();
        }
    }
}
