package com.beastsoftware.beastfactions.factions.permission;

import com.beastsoftware.beastfactions.factions.entity.IPermission;
import com.beastsoftware.beastfactions.factions.entity.impl.Permission;
import com.beastsoftware.beastfactions.factions.struct.FactionPerm;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Singleton
public class PermissionManager implements IPermissionManager {


    private volatile HashMap<String, Permission> permissions;


    @Inject
    public PermissionManager() {
        this.permissions = new HashMap<>();
        for (FactionPerm perm : FactionPerm.values()) {
            this.permissions.put(perm.toString(), new Permission(perm.toString()));
        }

    }

    @Override
    public List<IPermission> getAllPermissions() {
        return new ArrayList<>(permissions.values());
    }

    @Override
    public Permission getPermission(String permissionName) {
        return permissions.get(permissionName);
    }

    @Override
    public List<IPermission> getRelationPermissablePermissions() {
        return Arrays.asList(FactionPerm.values())
                .parallelStream()
                .filter(FactionPerm::isRelationpermissable)
                .map(perm -> new Permission(perm.name()))
                .collect(Collectors.toList());

    }
}
