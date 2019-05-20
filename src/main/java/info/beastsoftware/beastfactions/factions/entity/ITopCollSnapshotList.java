package info.beastsoftware.beastfactions.factions.entity;

import java.util.List;

public interface ITopCollSnapshotList {


    void add(ITopCollSnapshot snapshot);

    void remove(ITopCollSnapshot snapshot);

    List<ITopCollSnapshot> get();


}
