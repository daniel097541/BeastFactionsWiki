package info.beastsoftware.beastfactions.factions.entity.impl;

import info.beastsoftware.beastfactions.factions.entity.IFactionRole;
import info.beastsoftware.beastfactions.factions.entity.IRolesColl;

import java.util.ArrayList;
import java.util.List;

public class RolesColl implements IRolesColl {

    private List<IFactionRole> roles;

    public RolesColl(List<IFactionRole> roles) {
        this.roles = roles;
    }

    public RolesColl() {
        this.roles = new ArrayList<>();
    }

    public List<IFactionRole> getRoles() {
        return roles;
    }

    public void add(FactionRole role){
        roles.add(role);
    }

    public void remove(IFactionRole role){
        roles.remove(role);
    }
}
