package com.beastsoftware.beastfactions.factions.entity.impl;

import com.beastsoftware.beastfactions.factions.entity.IPermission;
import com.beastsoftware.beastfactions.factions.entity.IRelation;
import com.beastsoftware.beastfactions.factions.entity.IRelationsPermissionsColl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RelationsPermissionsColl implements IRelationsPermissionsColl {


    private HashMap<String, List<String>> relationsPermissions;

    public RelationsPermissionsColl() {
        this.relationsPermissions = new HashMap<>();
    }


    @Override
    public void add(IRelation relation, IPermission permission) {
        if (!relationsPermissions.containsKey(relation.getName()))
            relationsPermissions.put(relation.getName(), new ArrayList<>());

        relationsPermissions.get(relation.getName()).add(permission.getName());
    }

    @Override
    public void remove(IRelation relation, IPermission permission) {
        if (!relationsPermissions.containsKey(relation.getName())) return;
        relationsPermissions.get(relation.getName()).remove(permission.getName());
    }

    @Override
    public boolean hasPermission(IRelation relation, IPermission permission) {
        if (!relationsPermissions.containsKey(relation.getName()))
            return false;
        return relationsPermissions.get(relation.getName()).contains(permission.getName());
    }

    @Override
    public List<IPermission> getPermissionsOfRelation(IRelation relation) {
        List<IPermission> permissions = new ArrayList<>();

        for (String perm : relationsPermissions.get(relation.getName())) {
            IPermission permission = new Permission(perm);
            permissions.add(permission);
        }

        return permissions;
    }
}
