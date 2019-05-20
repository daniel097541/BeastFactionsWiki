package info.beastsoftware.beastfactions.factions.unclaimmanager;

import info.beastsoftware.beastfactions.factions.entity.IFPlayer;
import info.beastsoftware.beastfactions.manager.IManager;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import java.util.HashMap;
import java.util.UUID;


@Singleton
public class UnclaimAllManager implements IManager<IFPlayer> {


    private volatile HashMap<UUID, IFPlayer> cache;


    @Inject
    public UnclaimAllManager() {
        this.cache = new HashMap<>();
    }


    @Override
    public void add(IFPlayer object) {
        this.cache.put(object.getUuid(), object);
    }

    @Override
    public void remove(IFPlayer object) {
        this.cache.remove(object.getUuid());
    }

    @Override
    public boolean isPresent(IFPlayer object) {
        return cache.containsKey(object.getUuid());
    }

    @Override
    public void removeAll() {
        this.cache = new HashMap<>();
    }
}
