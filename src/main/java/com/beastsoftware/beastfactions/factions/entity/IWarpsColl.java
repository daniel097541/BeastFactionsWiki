package com.beastsoftware.beastfactions.factions.entity;

import java.util.HashMap;
import java.util.List;

public interface IWarpsColl {
    IFactionWarp get(String key);

    void put(String key, IFactionWarp value);

    void remove(String key);

    HashMap<String, IFactionWarp> getWarps();

    List<IPermission> getPermissions();

    IPermission getWarpPermission(String permissionName);
}
