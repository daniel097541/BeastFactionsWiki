package com.beastsoftware.beastfactions.factions.entity;

import com.beastsoftware.beastfactions.factions.entity.impl.PermissionsColl;
import com.beastsoftware.beastfactions.factions.gui.entity.gui.IGUI;
import com.beastsoftware.beastfactions.factions.struct.FactionPerm;
import org.bukkit.Location;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

public interface IFPlayer extends Serializable {

    String getName();

    UUID getUuid();

    int getPower();

    int getMaxPower();

    Player getPlayer();

    OfflinePlayer getOfflinePlayer();

    boolean isOnline();

    IFaction getFaction();

    void setPower(int power);

    void setMaxPower(int maxPower);

    long getFactionId();

    void setFactionId(long factionId);

    boolean hasFaction();

    boolean isOwner();

    IFactionRole getRole();

    void setRole(IFactionRole role);

    boolean hasPermission(FactionPerm permission);

    void addPermissionAsPlayer(IPermission permission);

    void removePermissionAsPlayer(IPermission permission);

    boolean hasPermissionAsPlayer(IPermission permission);

    List<IPermission> getPermissionsAsPlayer();

    IRelation getRelationWith(IFPlayer player);

    IRelation getRelationWithFaction(IFaction faction);

    boolean isInFaction(IFaction faction);

    IFaction getFactionWhereIAm();

    IFPlayer getNearbiestPlayerInRadius(int radius);

    IFPlayer getNearbyPlayerInRadiusWithRelation(int radius, IRelation relation);

    List<IFPlayer> getAllNearbyFPlayersInRadius(int radius);

    boolean isFlying();

    void toggleFlight();

    boolean canEnableFlightDueNearbyPlayers(int radius);

    Location getHomeLocation();

    boolean isInOwnLand();

    boolean isAutoClaiming();

    void stopAutoClaiming();

    void startAutoClaiming();

    int getPriority();

    boolean hasMorePriorityThan(IFPlayer otherPlayer);

    void save();

    void setRoleName(String role);

    void setUUID(UUID uuid);

    void setName(String name);

    boolean canBypassWarmUps();

    void setPermissions(List<IPermission> permissions);

    IPermissionsColl getPermissionsColl();

    void setPermissionsColl(PermissionsColl permissionsColl);

    void sms(String message);

    IChatMode getChatMode();

    void setChatMode(IChatMode chatMode);

    boolean hasPermission(IPermission permission);

    boolean isUnclaimingAll();

    void startUnclaimingAll();

    void stopUnclaimingAll();

    boolean isDisbanding();

    void startDisbanding();

    void stopDisbanding();

    boolean hasFallDamage();

    void disableFallDamage();

    void enableFallDamage();

    int getMapSize();

    void setMapSize(int mapSize);

    IMap getMapAround(int mapSize);

    IFactionsLocation getLocation();

    boolean isWatchingMap();

    void startWatchingMap();

    void stopWatchingMap();

    void sendMap(int mapSize);

    boolean isFactionLess();

    double getMoney();

    double setMoney(double money);

    void clearMoney();

    double addMoney(double money);

    void takeMoney(double money);

    boolean isAdminBypassing();

    void startAdminBypassing();

    void stopAdminBypassing();

    List<IFPlayer> getNearbyPlayersOfSameFaction(int radius);

    boolean isSeeingChunk();

    void startSeeingChunk();

    void stopSeeingChunk();

    IFChunk getChunkWhereIAm();

    void load();

    void unLoad();


    void changedLandEvent(IFaction from, IFaction to);

//
//    void leftLand(IFaction from, IFaction to);
//
//    void enteredLand(IFaction faction);

    void sendTopProgress(int record, IFaction faction);

    void depositMoney(IFaction faction, long amount);

    void withdrawMoney(IFaction faction, long amount);

    boolean canFlyInFaction(IFaction faction);

    boolean hasPermissionToFly();

    void sendTitle(String title, int fadeIn, int stay, int fadeOut);

    boolean isInFactionsLand(IFaction faction);

    void openGUI(IGUI gui, int page);

    void closeGUI();

    int getAmountOfTnTInInventory();

    void clearTnTFromInventory(int amount);

    int getFreeSlotsInInventory();

    void addTnTToInventory(int amount);

}
