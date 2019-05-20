package info.beastsoftware.beastfactions.factions.entity.impl;

import info.beastsoftware.beastfactions.factions.entity.IRelationsColl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RelationsColl implements IRelationsColl {

    private HashMap<String, List<Long>> relations;


    public RelationsColl(HashMap<String, List<Long>> relations) {
        this.relations = relations;
    }

    public RelationsColl() {
        this.relations = new HashMap<>();
    }


    public void put(String key, List<Long> value) {
        this.relations.put(key,value);
    }

    public void remove(String key){
        this.relations.remove(key);
    }

    public List<Long> get(String key) {
        return relations.get(key);
    }

    public HashMap<String, List<Long>> getRelations() {
        return relations;
    }

    public void addRelation(String relation, long faction) {

        //remove older relations with that fac
        for (Map.Entry<String, List<Long>> entry : relations.entrySet()) {
            entry.getValue().remove(faction);
        }

        relations.get(relation).add(faction);
    }



}
