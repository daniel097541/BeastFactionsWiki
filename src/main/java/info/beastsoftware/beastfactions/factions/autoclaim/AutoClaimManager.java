package info.beastsoftware.beastfactions.factions.autoclaim;

import info.beastsoftware.beastfactions.factions.entity.IFPlayer;
import info.beastsoftware.beastfactions.manager.IManager;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import java.util.HashMap;
import java.util.UUID;

@Singleton
public class AutoClaimManager implements IManager<IFPlayer> {

    private HashMap<UUID, IFPlayer> autoclaiming;

    @Inject
    private AutoClaimManager() {
        this.autoclaiming = new HashMap<>();
    }

    @Override
    public void add(IFPlayer object) {
        this.autoclaiming.put(object.getUuid(), object);
    }

    @Override
    public void remove(IFPlayer object) {
        this.autoclaiming.remove(object.getUuid());
    }

    @Override
    public boolean isPresent(IFPlayer object) {
        return autoclaiming.containsKey(object.getUuid());
    }

    @Override
    public void removeAll() {
        this.autoclaiming = new HashMap<>();
    }
}
