package com.beastsoftware.beastfactions.factions.permission;

import com.beastsoftware.beastfactions.factions.entity.IPermission;
import com.beastsoftware.beastfactions.factions.entity.impl.Permission;

import java.util.List;

public interface IPermissionManager {

    List<IPermission> getAllPermissions();

    Permission getPermission(String permissionName);

    List<IPermission> getRelationPermissablePermissions();

}
