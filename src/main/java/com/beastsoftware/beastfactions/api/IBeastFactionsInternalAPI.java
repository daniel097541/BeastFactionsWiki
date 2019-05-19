package com.beastsoftware.beastfactions.api;

import com.beastsoftware.beastfactions.factions.command.executor.IFactionSubCommand;
import com.beastsoftware.beastfactions.factions.defaultFactions.IDefaultFactionsManager;
import com.beastsoftware.beastfactions.factions.entity.*;
import com.beastsoftware.beastfactions.factions.entity.impl.Permission;
import com.beastsoftware.beastfactions.factions.top.IFactionsTop;
import com.beastsoftware.beastfactions.hook.IHookManager;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.UUID;

public interface IBeastFactionsInternalAPI {


    IFaction getFactionFromName(String name);

    IFaction getFactionFromId(long id);

    List<IFaction> getAllFactions();

    IFPlayer getFPlayer(Player player);

    IFPlayer getFPlayer(UUID uuid);

    IFPlayer getFPlayer(String name);

    IFactionRole getPlayersRole(IFPlayer player);

    void addSubCommand(IFactionSubCommand subCommand);

    void addAlias(String command, String alias);

    IRelation getRelation(String relationName);

    IRelation getDefaultRelation();

    IRelation getOwnRelation();

    IFaction getFactionAtLocation(Location location);

    IFaction getFactionAtChunkCoords(int x, int z, String worldName);

    List<IClaim> getAllClaims(IFaction faction);

    List<IClaim> getAllClaimsInWorld(IFaction faction, World world);

    IClaim getClaimAt(Chunk chunk, IFaction faction);

    boolean isFlying(IFPlayer ifPlayer);

    List<IFPlayer> getAllFPlayersAtChunk(Chunk chunk);

    void addClaim(IFaction faction, Chunk chunk, IFPlayer claimer);

    void removeClaim(IFaction faction, Chunk chunk);

    boolean isAutoClaiming(IFPlayer fPlayer);

    void setAutoClaiming(IFPlayer fPlayer);

    void removeAutoClaiming(IFPlayer fPlayer);

    Permission getPermission(String permissionName);

    long generateNewIdForFaction();

    IFactionsTop getTop();

    IChatMode getChatModeOfRelation(IRelation relation);

    boolean relationHasChatMode(IRelation relation);

    boolean isUnclaimingAll(IFPlayer player);

    void addUnclaimingAll(IFPlayer player);

    void removeUnclaimingAll(IFPlayer player);

    void addToConfirmDisband(IFPlayer player);

    void removeConfirmingDisband(IFPlayer player);

    boolean isConfirmingDisband(IFPlayer player);

    void disableFallDamage(IFPlayer player);

    void enableFallDamage(IFPlayer player);

    boolean hasFallDamage(IFPlayer player);

    boolean isWatchingMap(IFPlayer player);

    void startWatchingMap(IFPlayer player);

    void stopWatchingMap(IFPlayer player);

    IDefaultFactionsManager getDefaultFactionsManager();

    List<IDefaultFaction> getDefaultFactions();

    IDefaultFaction getFactionlessFaction();

    IClaimColl getClaimColl(IFaction faction);

    IHookManager getHookManager();

    boolean isBypassing(IFPlayer player);

    void addBypassing(IFPlayer player);

    void removeBypassing(IFPlayer player);

    List<IFPlayer> getAllOnlinePlayers();

    boolean isSeeingChunk(IFPlayer player);

    void startSeeingChunk(IFPlayer player);

    void removeSeeingChunk(IFPlayer player);

    void removeClaimAtFChunk(IFChunk chunk, IFaction faction);

    void addClaimAtFChunk(IFChunk chunk, IFaction faction);

    boolean isHookedIntoEpicSpawners();

    int getAmountOfSpawnersStacked(Location location);

    UUID getServerName();

    boolean hasTopProgress(IFaction faction);

    IFactionTopProgress getTopProgress(IFaction faction);

    void migrateData();

    boolean checkMysql();

}
