package info.beastsoftware.beastfactions.factions.entity.impl;

import info.beastsoftware.beastfactions.factions.entity.IFactionWarp;
import info.beastsoftware.beastfactions.factions.entity.IPermission;
import info.beastsoftware.beastfactions.factions.entity.IWarpsColl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WarpsColl implements IWarpsColl {

    private HashMap<String, IFactionWarp> warps;


    public WarpsColl(HashMap<String, IFactionWarp> warps) {
        this.warps = warps;
    }

    WarpsColl() {
        this.warps = new HashMap<>();
    }

    public IFactionWarp get(String key) {
        return warps.get(key);
    }

    public void put(String key, IFactionWarp value){
        warps.put(key, value);
    }

    public void remove(String key){
        warps.remove(key);
    }

    public HashMap<String, IFactionWarp> getWarps() {
        return warps;
    }

    @Override
    public List<IPermission> getPermissions() {
        List<IPermission> permissions = new ArrayList<>();
        for (IFactionWarp warp : warps.values()) {
            permissions.add(warp.getPermission());
        }
        return permissions;
    }

    @Override
    public IPermission getWarpPermission(String permissionName) {
        for (IFactionWarp warp : warps.values())
            if (warp.getPermission().getName().equalsIgnoreCase(permissionName))
                return warp.getPermission();
        return null;
    }
}
