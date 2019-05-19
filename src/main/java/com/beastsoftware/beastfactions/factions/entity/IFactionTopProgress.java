package com.beastsoftware.beastfactions.factions.entity;

import java.util.Date;
import java.util.List;

public interface IFactionTopProgress {


    ITopCollSnapshot getSnapShot(Date date);

    void addSnapShot(ITopCollSnapshot snapshot);

    void removeSnapShot(ITopCollSnapshot snapshot);

    List<ITopCollSnapshot> getAllSnapShots();

    void save();

    IFaction getFaction();

    long getFactionId();

    ITopCollSnapshotList getSnapshotList();


}
