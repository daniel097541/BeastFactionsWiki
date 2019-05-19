package com.beastsoftware.beastfactions.factions.entity.impl;

import com.beastsoftware.beastfactions.factions.entity.IPermission;
import com.beastsoftware.beastfactions.factions.entity.IPermissionsColl;

import java.util.ArrayList;
import java.util.List;

public class PermissionsColl implements IPermissionsColl {


    private volatile List<String> permissions;

    PermissionsColl(List<IPermission> permissions) {
        this.permissions = new ArrayList<>();
        for (IPermission permission : permissions)
            this.permissions.add(permission.getName());
    }

    PermissionsColl() {
        this.permissions = new ArrayList<>();
    }


    public List<IPermission> getPermissions() {
        List<IPermission> permissions = new ArrayList<>();
        for (String perm : this.permissions)
            permissions.add(new Permission(perm));
        return permissions;
    }

    public void add(IPermission permission) {
        this.permissions.add(permission.getName());
    }

    public void remove(IPermission permission)
    {
        permissions.remove(permission.getName());
    }

    public boolean contains(IPermission permission) {
        return permissions.contains(permission.getName());
    }

}
