package info.beastsoftware.beastfactions.factions.entity;

import java.util.List;

public interface IPlayerColl {
    List<String> getfPlayers();

    void add(String player);

    void remove(String player);

    void addAll(List<String> players);
}
