package info.beastsoftware.beastfactions.factions.entity.impl;

import info.beastsoftware.beastfactions.BeastFactions;
import info.beastsoftware.beastfactions.factions.entity.IFaction;
import info.beastsoftware.beastfactions.factions.entity.IFactionTopProgress;
import info.beastsoftware.beastfactions.factions.entity.ITopCollSnapshot;
import info.beastsoftware.beastfactions.factions.entity.ITopCollSnapshotList;
import info.beastsoftware.beastfactions.factions.event.TopProgressSaveEvent;
import info.beastsoftware.beastfactions.factions.util.SortByDate;
import org.bukkit.Bukkit;

import java.util.Date;
import java.util.List;

public class FactionTopProgress implements IFactionTopProgress {

    private final ITopCollSnapshotList snapshots;
    private final long factionId;

    public FactionTopProgress(List<ITopCollSnapshot> snapshots, long factionId) {
        this.snapshots = new TopCollSnapshotList(snapshots);
        this.factionId = factionId;
    }

    public FactionTopProgress(ITopCollSnapshotList snapshots, long factionId) {
        this.snapshots = snapshots;
        this.factionId = factionId;
    }

    @Override
    public ITopCollSnapshot getSnapShot(Date date) {
        for (ITopCollSnapshot snapshot : snapshots.get())
            if (snapshot.getDate().equals(date))
                return snapshot;
        return null;
    }

    @Override
    public void addSnapShot(ITopCollSnapshot snapshot) {
        snapshots.add(snapshot);
    }

    @Override
    public void removeSnapShot(ITopCollSnapshot snapshot) {
        snapshots.remove(snapshot);
    }

    @Override
    public List<ITopCollSnapshot> getAllSnapShots() {
        snapshots.get().sort(new SortByDate());
        return snapshots.get();
    }

    @Override
    public void save() {
        Bukkit.getPluginManager().callEvent(new TopProgressSaveEvent(getFaction(), this));
    }

    @Override
    public IFaction getFaction() {
        return BeastFactions.getInstance().getInternalApi().getFactionFromId(factionId);
    }

    @Override
    public long getFactionId() {
        return factionId;
    }

    @Override
    public ITopCollSnapshotList getSnapshotList() {
        return snapshots;
    }
}
