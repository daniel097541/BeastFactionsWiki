package com.beastsoftware.beastfactions.factions.entity;

import com.beastsoftware.beastfactions.factions.entity.impl.FactionRole;

import java.util.List;

public interface IRolesColl {

    List<IFactionRole> getRoles();

    void add(FactionRole role);

    void remove(IFactionRole role);
}
