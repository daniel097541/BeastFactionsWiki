package com.beastsoftware.beastfactions.factions.entity;

import java.io.Serializable;
import java.util.List;

public interface IRelationsPermissionsColl extends Serializable {


    void add(IRelation relation, IPermission permission);

    void remove(IRelation relation, IPermission permission);

    boolean hasPermission(IRelation relation, IPermission permission);

    List<IPermission> getPermissionsOfRelation(IRelation relation);


}
