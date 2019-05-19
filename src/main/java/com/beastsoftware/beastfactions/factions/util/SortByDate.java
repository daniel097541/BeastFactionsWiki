package com.beastsoftware.beastfactions.factions.util;

import com.beastsoftware.beastfactions.factions.entity.ITopCollSnapshot;

import java.util.Comparator;

public class SortByDate implements Comparator<ITopCollSnapshot> {
    @Override
    public int compare(ITopCollSnapshot o1, ITopCollSnapshot o2) {
        return (int) (o2.getDate().getTime() - o1.getDate().getTime());
    }
}
