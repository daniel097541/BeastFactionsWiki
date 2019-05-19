package com.beastsoftware.beastfactions.factions.entity;

import java.util.HashMap;
import java.util.List;

public interface IRelationsColl {
    void put(String key, List<Long> value);

    void remove(String key);

    List<Long> get(String key);

    HashMap<String, List<Long>> getRelations();

    void addRelation(String relation, long faction);
}
