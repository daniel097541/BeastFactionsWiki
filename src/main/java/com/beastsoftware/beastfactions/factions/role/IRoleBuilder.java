package com.beastsoftware.beastfactions.factions.role;

import com.beastsoftware.beastfactions.factions.entity.IFactionRole;
import com.beastsoftware.beastfactions.factions.entity.IPermission;

import java.util.List;

public interface IRoleBuilder {


    IFactionRole createRole(String name, String displayName, List<IPermission> permissions, boolean defaultRole, int priority);

    List<IFactionRole> createDefaultRoles();


}
