package info.beastsoftware.beastfactions.factions.entity;


import java.util.List;

public interface IPermissionsColl {
    List<IPermission> getPermissions();

    void add(IPermission permission);

    void remove(IPermission permission);

    boolean contains(IPermission permission);
}
