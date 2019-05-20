package info.beastsoftware.beastfactions.factions.entity.impl;

import info.beastsoftware.beastfactions.factions.entity.IPlayerColl;

import java.util.ArrayList;
import java.util.List;

public class PlayerColl implements IPlayerColl {

    private List<String> fPlayers;

    public PlayerColl(List<String> fPlayers) {
        this.fPlayers = fPlayers;
    }

    public PlayerColl() {
        fPlayers = new ArrayList<>();
    }

    public List<String> getfPlayers() {
        return fPlayers;
    }

    public void add(String player){
        fPlayers.add(player);
    }

    public void remove(String player){
        fPlayers.remove(player);
    }

    @Override
    public void addAll(List<String> players) {
        fPlayers.addAll(players);
    }
}
