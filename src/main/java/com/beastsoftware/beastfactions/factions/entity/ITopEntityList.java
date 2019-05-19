package com.beastsoftware.beastfactions.factions.entity;

import java.util.List;

public interface ITopEntityList {

    List<ITopEntity> getList();

    void setList(List<ITopEntity> list);

    void add(ITopEntity entity);

    void remove(ITopEntity entity);

}
