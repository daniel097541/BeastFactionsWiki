package info.beastsoftware.beastfactions.factions.entity.impl;

import info.beastsoftware.beastfactions.factions.entity.ITopEntity;
import info.beastsoftware.beastfactions.factions.entity.ITopEntityList;

import java.util.ArrayList;
import java.util.List;

public class TopEntityList implements ITopEntityList {

    private List<ITopEntity> list;


    public TopEntityList(List<ITopEntity> list) {
        this.list = list;
    }

    public TopEntityList() {
        this.list = new ArrayList<>();
    }

    @Override
    public List<ITopEntity> getList() {
        return list;
    }

    @Override
    public void setList(List<ITopEntity> list) {
        this.list = list;
    }

    @Override
    public void add(ITopEntity entity) {
        list.add(entity);
    }

    @Override
    public void remove(ITopEntity entity) {
        list.remove(entity);
    }
}
