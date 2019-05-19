package com.beastsoftware.beastfactions.manager;

public interface IManager<T> {

    void add(T object);

    void remove(T object);

    boolean isPresent(T object);

    void removeAll();

}
