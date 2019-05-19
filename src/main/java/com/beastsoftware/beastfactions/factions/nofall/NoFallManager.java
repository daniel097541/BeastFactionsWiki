package com.beastsoftware.beastfactions.factions.nofall;

import com.beastsoftware.beastfactions.factions.entity.IFPlayer;
import com.beastsoftware.beastfactions.manager.IManager;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import java.util.HashMap;
import java.util.UUID;

@Singleton
public class NoFallManager implements IManager<IFPlayer> {


    private volatile HashMap<UUID, IFPlayer> cache;


    @Inject
    public NoFallManager() {
        this.cache = new HashMap<>();
    }

    @Override
    public void add(IFPlayer object) {
        cache.put(object.getUuid(), object);
    }

    @Override
    public void remove(IFPlayer object) {
        cache.remove(object.getUuid());
    }

    @Override
    public boolean isPresent(IFPlayer object) {
        return cache.containsKey(object.getUuid());
    }

    @Override
    public void removeAll() {
        cache.clear();
    }
}
