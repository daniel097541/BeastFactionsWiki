package info.beastsoftware.beastfactions.factions.permission;

import info.beastsoftware.beastfactions.factions.entity.IPermission;
import info.beastsoftware.beastfactions.factions.entity.impl.Permission;

import java.util.List;

public interface IPermissionManager {

    List<IPermission> getAllPermissions();

    Permission getPermission(String permissionName);

    List<IPermission> getRelationPermissablePermissions();

}
