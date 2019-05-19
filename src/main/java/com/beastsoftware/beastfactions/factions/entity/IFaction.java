package com.beastsoftware.beastfactions.factions.entity;

import com.beastsoftware.beastfactions.factions.entity.impl.PlayerColl;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.World;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public interface IFaction extends Serializable {


    int getPower();

    int getMaxPower();

    int getSize();

    String getName();

    long getId();

    List<IFPlayer> getFPlayers();

    void setFPlayers(List<IFPlayer> fPlayers);

    List<IFPlayer> getOnlineFPlayers();

    List<IFPlayer> getFPlayersWithRole(String role);

    void addFPlayer(IFPlayer fPlayer);

    void removeFPlayer(IFPlayer fPlayer);

    void removeFPlayer(UUID uuid);

    void removeFPlayer(String name);

    void setName(String name);

    void setId(long id);

    IFPlayer getOwner();

    void setOwner(String owner);

    List<IFactionRole> getCustomRoles();

    void setCustomRoles(List<IFactionRole> customRoles);

    IFactionRole getDefaultFactionRole();

    IFactionRole getAdminFactionRole();

    void addFactionRole(IFactionRole role);

    IFactionRole getFactionRole(String role);

    List<Long> getFactionRelations(String relationName);

    HashMap<String, List<Long>> getRelations();

    void setRelations(HashMap<String, List<Long>> relations);

    IRelation getRelationWith(IFaction faction);

    List<IClaim> getALlClaims();

    List<IClaim> getClaimsInWorld(World world);

    boolean canBeOverClaimed();

    int getAmountOfClaims();

    boolean canClaim(IFPlayer player);

    boolean isDefaultFaction();

    Location getHomeLocation();

    void setHomeLocation(Location location);

    void addClaim(Chunk chunk, IFPlayer claimer);

    void removeClaim(Chunk chunk);

    boolean isClaim(Chunk chunk);

    boolean isClaim(Location location);

    void removeRole(IFactionRole role);

    void addWarp(IFactionWarp warp);

    void removeWarp(IFactionWarp warp);

    void removeWarps(List<IFactionWarp> warps);

    IFactionWarp getWarp(String name);

    List<IFactionWarp> getWarps();

    IRolesColl getRolesColl();

    void setPlayersColl(PlayerColl playersColl);

    void setHome(IFactionsLocation home);

    IPlayerColl getPlayersColl();

    void setRolesColl(IRolesColl rolesColl);

    IWarpsColl getWarpsColl();

    void setWarpsColl(IWarpsColl warpsColl);

    IRelationsColl getRelationsColl();

    void setRelationsColl(IRelationsColl relationsColl);

    IFactionsLocation getHomeFactionsLocation();

    void setRelation(IRelation relation, IFaction target);

    boolean isSame(IFaction faction);

    void createClaims();

    void createTop();

    List<IFPlayer> getAllOnlinePlayersWithRelation(IRelation relation);

    void save();

    int getTopPosition();

    boolean isFactionless();

    String getColor();

    boolean unclaimAllLand();

    boolean unclaimAllLandByPlayer(IFPlayer player);

    IFPlayer getRichestPlayer();

    double getTotalMoneyOfPlayers();

    String getNameColorFormattedWithFaction(IFaction faction);

    void removeClaimAtFChunk(IFChunk chunk);

    void removeTopEntitiesFromClaims(List<IClaim> claims);

    void checkAndAddSpawnersInChunk(Chunk chunk);

    void removeTopEntitiesAtFChunk(IFChunk chunk);

    long getAllPlayersMoney();

    ITopCollSnapshot getTopSnapshotNow();

    ITopEntityColl getTopEntityColl();

    boolean hasRecord(int record);

    IFactionTopProgress getProgress();

    long getMoneyInBank();

    void setMoneyInBank(long money);

    void depositMoneyInBank(long money);

    long withdrawMoneyInBank(long money);

    void clearMoneyInBank();

    List<IPermission> getWarpPermissions();

    IPermission getWarpPermission(String permissionName);

    void warn();

    int getWarnings();

    void setWarnings(int warnings);

    void broadcastMessage(String message);

    boolean hasRelationPermission(IRelation relation, IPermission permission);

    List<IPermission> getPermissionsOfRelation(IRelation relation);

    void addPermissionToRelation(IRelation relation, IPermission permission);

    void removePermissionFromRelation(IRelation relation, IPermission permission);

    int getMaxPlayers();

    void setMaxPlayers(int maxPlayers);

    boolean canEnterNewPlayers();

    long getTnTInBank();

    void setTnTInBank(long amount);

    void removeTnTFromBank(long amount);

    void addTnTToBank(long amount);

    void clearTnTBank();


}
