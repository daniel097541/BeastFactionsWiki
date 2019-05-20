package info.beastsoftware.beastfactions.factions.entity.impl;

import info.beastsoftware.beastfactions.factions.entity.IPermission;


public class Permission implements IPermission {

    private String name;

    public Permission(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Permission that = (Permission) o;
        return that.hashCode() == this.hashCode();
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
