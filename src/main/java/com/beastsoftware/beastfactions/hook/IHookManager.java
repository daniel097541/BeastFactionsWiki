package com.beastsoftware.beastfactions.hook;

public interface IHookManager {

    boolean isEconomyHooked();

    IEconomyHook getEconomyHook();

    boolean isEpicSpawnersHooked();

    IEpicSpawnersHook getEpicSpawnersHook();

    boolean isWorldEditHooked();

    IWorldEditHook getWorldEditHook();

}
