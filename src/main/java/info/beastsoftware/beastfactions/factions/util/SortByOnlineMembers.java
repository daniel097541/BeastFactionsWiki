package info.beastsoftware.beastfactions.factions.util;

import info.beastsoftware.beastfactions.factions.entity.IFaction;

import java.io.Serializable;
import java.util.Comparator;

public class SortByOnlineMembers implements Comparator<IFaction>, Serializable {

    @Override
    public int compare(IFaction o1, IFaction o2) {
        return o2.getOnlineFPlayers().size() - o1.getOnlineFPlayers().size();
    }
}
