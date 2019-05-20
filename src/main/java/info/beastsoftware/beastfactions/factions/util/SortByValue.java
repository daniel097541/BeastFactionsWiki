package info.beastsoftware.beastfactions.factions.util;

import info.beastsoftware.beastfactions.factions.entity.IFaction;
import info.beastsoftware.beastfactions.factions.entity.ITopEntityColl;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Map;

public class SortByValue implements Comparator<Map.Entry<IFaction, ITopEntityColl>>, Serializable {


    @Override
    public int compare(Map.Entry<IFaction, ITopEntityColl> o1, Map.Entry<IFaction, ITopEntityColl> o2) {
        return Long.compare(o2.getValue().getTotalValue(), o1.getValue().getTotalValue());
    }
}
