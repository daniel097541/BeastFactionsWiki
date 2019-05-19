package com.beastsoftware.beastfactions.factions.entity.impl;

import com.beastsoftware.beastfactions.factions.entity.ITopCollSnapshot;
import com.beastsoftware.beastfactions.factions.entity.ITopCollSnapshotList;

import java.util.List;

public class TopCollSnapshotList implements ITopCollSnapshotList {


    private final List<ITopCollSnapshot> snapshots;

    public TopCollSnapshotList(List<ITopCollSnapshot> snapshots) {
        this.snapshots = snapshots;
    }


    @Override
    public void add(ITopCollSnapshot snapshot) {
        snapshots.add(snapshot);
    }

    @Override
    public void remove(ITopCollSnapshot snapshot) {
        snapshots.remove(snapshot);
    }

    @Override
    public List<ITopCollSnapshot> get() {
        return snapshots;
    }
}
