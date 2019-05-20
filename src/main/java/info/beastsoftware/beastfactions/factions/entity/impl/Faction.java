package info.beastsoftware.beastfactions.factions.entity.impl;

import info.beastsoftware.beastfactions.BeastFactions;
import info.beastsoftware.beastfactions.factions.entity.*;
import info.beastsoftware.beastfactions.factions.event.*;
import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.World;
import utils.StrUtils;

import java.util.Map;
import java.util.*;
import java.util.stream.Collectors;

public class Faction implements IFaction {

    private String name;

    private long id;

    private IPlayerColl fPlayersUUIDs;

    private String owner;

    private IRolesColl customRoles;

    private IRelationsColl relations;

    private IFactionsLocation homeLocation;

    private IWarpsColl warps;

    private long moneyInBank;

    private int warnings;

    private IRelationsPermissionsColl relationsPermissionsColl;

    private int maxPlayers;

    private long tnt;



    public Faction() {
        this.fPlayersUUIDs = new PlayerColl();
        this.relations = new RelationsColl();
        this.warps = new WarpsColl();
        this.relationsPermissionsColl = new RelationsPermissionsColl();
    }


    public Faction(String name, long id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public int getPower() {

        int pow = 0;

        for (IFPlayer player : getFPlayers())
            pow += player.getPower();
        return pow;
    }


    @Override
    public int getMaxPower() {
        int maxPower = 0;
        for (IFPlayer player : getFPlayers())
            maxPower += player.getMaxPower();
        return maxPower;
    }

    @Override
    public int getSize() {
        return fPlayersUUIDs.getfPlayers().size();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public List<IFPlayer> getFPlayers() {

        if (isDefaultFaction()) return new ArrayList<>();

        return fPlayersUUIDs.getfPlayers()
                .parallelStream()
                .map(uuid -> {
                    UUID realUUID = UUID.fromString(uuid);
                    return BeastFactions.getInstance().getInternalApi().getFPlayer(realUUID);
                })
                .collect(Collectors.toList());
    }

    @Override
    public void setFPlayers(List<IFPlayer> fPlayers) {
//        for (IFPlayer ifPlayer : fPlayers) {
//            fPlayersUUIDs.add(ifPlayer.getUuid().toString());
//        }
//
        fPlayersUUIDs.addAll(
                fPlayers
                        .parallelStream()
                        .map(player -> player.getUuid().toString())
                        .collect(Collectors.toList())
        );
    }

    @Override
    public List<IFPlayer> getOnlineFPlayers() {

        if (isDefaultFaction()) return new ArrayList<>();

        return fPlayersUUIDs.getfPlayers()
                .parallelStream()
                .map(uuid -> {
                    UUID realUUID = UUID.fromString(uuid);
                    return BeastFactions.getInstance().getInternalApi().getFPlayer(realUUID);
                })
                .filter(IFPlayer::isOnline)
                .collect(Collectors.toList());
    }

    @Override
    public List<IFPlayer> getFPlayersWithRole(String role) {

        return fPlayersUUIDs.getfPlayers()
                .parallelStream()
                .map(uuid -> {
                    UUID realUUID = UUID.fromString(uuid);
                    return BeastFactions.getInstance().getInternalApi().getFPlayer(realUUID);
                })
                .filter(player -> player.getRole().getRoleName().equalsIgnoreCase(role))
                .collect(Collectors.toList());
    }


    @Override
    public void addFPlayer(IFPlayer fPlayer) {
        this.fPlayersUUIDs.add(fPlayer.getUuid().toString());
    }

    @Override
    public void removeFPlayer(IFPlayer fPlayer) {
        this.fPlayersUUIDs.remove(fPlayer.getUuid().toString());
    }

    @Override
    public void removeFPlayer(UUID uuid) {
        this.fPlayersUUIDs.remove(uuid.toString());
    }

    @Override
    public void removeFPlayer(String name) {
        IFPlayer player = BeastFactions.getInstance().getInternalApi().getFPlayer(name);
        removeFPlayer(player.getUuid());
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    @Override
    public IFPlayer getOwner() {
        if (owner == null) return null;
        return BeastFactions.getInstance().getInternalApi().getFPlayer(UUID.fromString(owner));
    }

    @Override
    public void setOwner(String owner) {
        this.owner = owner;
    }


    public List<IFactionRole> getCustomRoles() {
        return customRoles.getRoles();
    }

    public void setCustomRoles(List<IFactionRole> customRoles) {
        this.customRoles = new RolesColl(customRoles);
    }

    @Override
    public IFactionRole getDefaultFactionRole() {

        return getCustomRoles()
                .parallelStream()
                .filter(IFactionRole::isDefaultRole)
                .findFirst()
                .orElse(null);
    }

    @Override
    public IFactionRole getAdminFactionRole() {
        return getCustomRoles()
                .parallelStream()
                .filter(role -> role.hasPermission(new Permission("ALL")))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void addFactionRole(IFactionRole role) {
        this.customRoles.add((FactionRole) role);
    }

    @Override
    public IFactionRole getFactionRole(String role) {
        return getCustomRoles()
                .parallelStream()
                .filter(r -> r.getRoleName().equalsIgnoreCase(role))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Long> getFactionRelations(String relationName) {
        return relations.get(relationName);
    }

    @Override
    public HashMap<String, List<Long>> getRelations() {
        return relations.getRelations();
    }

    @Override
    public void setRelations(HashMap<String, List<Long>> relations) {
        this.relations = new RelationsColl(relations);
    }

    @Override
    public IRelation getRelationWith(IFaction faction) {


        if (isDefaultFaction() || faction == null || faction.isDefaultFaction())
            return BeastFactions.getInstance().getInternalApi().getDefaultRelation();

        if (faction.getId() == this.getId())
            return BeastFactions.getInstance().getInternalApi().getOwnRelation();

        IRelation relation = null;

        for (Map.Entry<String, List<Long>> entry : relations.getRelations().entrySet()) {
            if (entry.getValue().contains(faction.getId()))
                relation = BeastFactions.getInstance().getInternalApi().getRelation(entry.getKey());
        }

        if (relation == null)
            relation = BeastFactions.getInstance().getInternalApi().getDefaultRelation();


        //if the target faction has not the same relation with us that we have with them
        if (!faction.getFactionRelations(relation.getName()).contains(this.getId())) {

            relation = BeastFactions.getInstance().getInternalApi().getDefaultRelation();

            //update their relation and our relation with the default one
            faction.setRelation(relation, this);
            this.setRelation(relation, faction);
        }

        return relation;
    }

    @Override
    public List<IClaim> getALlClaims() {
        return BeastFactions.getInstance().getInternalApi().getAllClaims(this);
    }

    @Override
    public List<IClaim> getClaimsInWorld(World world) {
        return BeastFactions.getInstance().getInternalApi().getAllClaimsInWorld(this, world);
    }

    @Override
    public boolean canBeOverClaimed() {
        if (isFactionless()) return true;
        if (isDefaultFaction()) return false;
        return getPower() < getAmountOfClaims();
    }

    @Override
    public int getAmountOfClaims() {
        return BeastFactions.getInstance().getInternalApi().getAllClaims(this).size();
    }

    @Override
    public boolean canClaim(IFPlayer player) {
        if (player != null && player.isAdminBypassing()) return true;
        return !(getPower() <= 0 || getPower() <= getAmountOfClaims());
    }


    @Override
    public boolean isDefaultFaction() {
        return this instanceof DefaultFaction || this.getId() <= 0;
    }

    @Override
    public Location getHomeLocation() {
        if (homeLocation == null) return null;
        return homeLocation.getLocation();
    }

    @Override
    public void setHomeLocation(Location location) {
        if (location == null) {
            this.homeLocation = null;
            return;
        }

        this.homeLocation = new FactionsLocation(location.getBlockX(), location.getBlockY(), location.getBlockZ(), location.getWorld().getName(), location.getDirection());
    }

    @Override
    public void addClaim(Chunk chunk, IFPlayer claimer) {
        Bukkit.getPluginManager().callEvent(new AddClaimEvent(claimer, chunk, this));
    }

    @Override
    public void removeClaim(Chunk chunk) {
        RemoveClaimAtFChunkEvent event = new RemoveClaimAtFChunkEvent(this, new FChunk(chunk));
        Bukkit.getPluginManager().callEvent(event);
    }

    @Override
    public boolean isClaim(Chunk chunk) {
        return isClaim(chunk.getBlock(0, 0, 0).getLocation());
    }

    @Override
    public boolean isClaim(Location location) {
        return BeastFactions.getInstance().getInternalApi().getFactionAtLocation(location).getId() == getId();
    }

    @Override
    public void removeRole(IFactionRole role) {
        customRoles.remove(role);
    }

    @Override
    public void addWarp(IFactionWarp warp) {
        warps.put(warp.getName(), warp);
    }

    @Override
    public void removeWarp(IFactionWarp warp) {
        warps.remove(warp.getName());
    }

    @Override
    public void removeWarps(List<IFactionWarp> warps) {
        for (IFactionWarp warp : warps)
            removeWarp(warp);
    }

    @Override
    public IFactionWarp getWarp(String name) {
        return warps.getWarps().values()
                .parallelStream()
                .filter(warp -> warp.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<IFactionWarp> getWarps() {
        return new ArrayList<>(warps.getWarps().values());
    }



    @Override
    public IRolesColl getRolesColl() {
        return customRoles;
    }

    @Override
    public void setPlayersColl(PlayerColl playersColl) {
        this.fPlayersUUIDs = playersColl;
    }

    @Override
    public void setHome(IFactionsLocation home) {
        this.homeLocation = home;
    }

    @Override
    public IPlayerColl getPlayersColl() {
        return fPlayersUUIDs;
    }

    @Override
    public void setRolesColl(IRolesColl rolesColl) {
        this.customRoles = rolesColl;
    }

    @Override
    public IWarpsColl getWarpsColl() {
        return warps;
    }

    @Override
    public void setWarpsColl(IWarpsColl warpsColl) {
        this.warps = warpsColl;
    }

    @Override
    public IRelationsColl getRelationsColl() {
        return relations;
    }

    @Override
    public void setRelationsColl(IRelationsColl relationsColl) {
        this.relations = relationsColl;
    }

    @Override
    public IFactionsLocation getHomeFactionsLocation() {
        return homeLocation;
    }

    @Override
    public void setRelation(IRelation relation, IFaction target) {
        relations.addRelation(relation.getName(), target.getId());
    }

    @Override
    public boolean isSame(IFaction faction) {
        return faction.getId() == getId();
    }

    @Override
    public void createClaims() {
        Bukkit.getPluginManager().callEvent(new ClaimCollCreationEvent(this));
    }

    @Override
    public void createTop() {
        Bukkit.getPluginManager().callEvent(new TopCreationEvent(this));
    }

    @Override
    public List<IFPlayer> getAllOnlinePlayersWithRelation(IRelation relation) {
        return Bukkit.getServer().getOnlinePlayers()
                .parallelStream()
                .map(player -> BeastFactions.getInstance().getInternalApi().getFPlayer(player))
                .filter(player -> player.getRelationWithFaction(this).equals(relation))
                .collect(Collectors.toList());
    }

    @Override
    public void save() {
        Bukkit.getPluginManager().callEvent(new FactionSaveEvent(this));
    }

    @Override
    public int getTopPosition() {
        return BeastFactions.getInstance().getInternalApi().getTop().getPositionOfFaction(this);
    }

    @Override
    public boolean isFactionless() {
        if (!isDefaultFaction()) return false;
        IDefaultFaction defaultFaction = (DefaultFaction) this;
        return defaultFaction.isFactionless();
    }

    @Override
    public String getColor() {
        if (!isDefaultFaction()) return null;
        IDefaultFaction defaultFaction = (IDefaultFaction) this;
        return defaultFaction.getColor();
    }

    @Override
    public boolean unclaimAllLand() {
        //call event
        UnclaimAllEvent event = new UnclaimAllEvent(this);
        Bukkit.getPluginManager().callEvent(event);

        return !event.isCancelled();
    }

    @Override
    public boolean unclaimAllLandByPlayer(IFPlayer player) {
        //call event
        UnclaimAllEvent event = new UnclaimAllEvent(this, player);
        Bukkit.getPluginManager().callEvent(event);

        return !event.isCancelled();
    }

    @Override
    public IFPlayer getRichestPlayer() {
        return getFPlayers()
                .parallelStream()
                .max(Comparator.comparingDouble(IFPlayer::getMoney))
                .orElse(null);
    }

    @Override
    public double getTotalMoneyOfPlayers() {
        return getFPlayers()
                .parallelStream()
                .mapToDouble(IFPlayer::getMoney)
                .sum();
    }

    @Override
    public String getNameColorFormattedWithFaction(IFaction faction) {

        String name = getName();

        if (isDefaultFaction()) {
            IDefaultFaction defaultFaction = (IDefaultFaction) this;
            return StrUtils.translate(defaultFaction.getColor() + name);
        }

        IRelation relation = getRelationWith(faction);
        return StrUtils.translate(relation.getColour() + name);
    }

    @Override
    public void removeClaimAtFChunk(IFChunk chunk) {
        Bukkit.getPluginManager().callEvent(new RemoveClaimAtFChunkEvent(this, chunk));
    }

    @Override
    public void removeTopEntitiesFromClaims(List<IClaim> claims) {
        Bukkit.getPluginManager().callEvent(new RemoveEntitiesFromClaimsEvent(this, claims));
    }

    @Override
    public void checkAndAddSpawnersInChunk(Chunk chunk) {
        Bukkit.getPluginManager().callEvent(new CheckAndAddSpawnersInChunkEvent(this, chunk));
    }

    @Override
    public void removeTopEntitiesAtFChunk(IFChunk chunk) {
        Bukkit.getPluginManager().callEvent(new RemoveTopEntitiesAtFChunkEvent(this, chunk));
    }

    @Override
    public long getAllPlayersMoney() {
        long total = 0L;
        for(IFPlayer player : getFPlayers())
            total += player.getMoney();
        return total;
    }

    @Override
    public ITopCollSnapshot getTopSnapshotNow() {

        ITopEntityColl coll = BeastFactions.getInstance().getInternalApi().getTop().getEntityColl(this);
        Date now = new Date();
        long totalValue = coll.getTotalValue();
        long playersMoney = getAllPlayersMoney();
        List<ISpawnerEntitySnapShot> spawnerEntitySnapShots = coll.getSpawnersSnapshots();
        List<IBlockEntitySnapshot> blockEntitySnapshots = coll.getBlocksSnapShots();

        return new TopCollSnapshot(now, coll.getFaction().getRichestPlayer().getUuid(), totalValue, playersMoney, spawnerEntitySnapShots, blockEntitySnapshots);
    }

    @Override
    public ITopEntityColl getTopEntityColl() {
        return BeastFactions.getInstance().getInternalApi().getTop().getEntityColl(this);
    }

    @Override
    public boolean hasRecord(int record) {
        if(!BeastFactions.getInstance().getInternalApi().hasTopProgress(this))
            return false;
        return BeastFactions.getInstance().getInternalApi().getTopProgress(this).getAllSnapShots().size() >= record;
    }

    @Override
    public IFactionTopProgress getProgress() {
        return BeastFactions.getInstance().getInternalApi().getTopProgress(this);
    }

    @Override
    public long getMoneyInBank() {
        return moneyInBank;
    }

    @Override
    public void setMoneyInBank(long money) {
        this.moneyInBank = money;
    }

    @Override
    public void depositMoneyInBank(long money) {
        moneyInBank += money;
    }

    @Override
    public long withdrawMoneyInBank(long money) {
        if (money >= moneyInBank) {
            long toReturn = moneyInBank;
            clearMoneyInBank();
            return toReturn;
        }

        moneyInBank -= money;
        return money;
    }

    @Override
    public void clearMoneyInBank() {
        setMoneyInBank(0L);
    }

    @Override
    public List<IPermission> getWarpPermissions() {
        return warps.getPermissions();
    }

    @Override
    public IPermission getWarpPermission(String permissionName) {
        return warps.getWarpPermission(permissionName);
    }

    @Override
    public void warn() {
        Bukkit.getPluginManager().callEvent(new WarnFactionEvent(this));
    }

    @Override
    public int getWarnings() {
        return warnings;
    }

    @Override
    public void setWarnings(int warnings) {
        this.warnings = warnings;
    }

    @Override
    public void broadcastMessage(String message) {

        getOnlineFPlayers()
                .forEach(player -> player.sms(message));

    }

    @Override
    public boolean hasRelationPermission(IRelation relation, IPermission permission) {
        if (relationsPermissionsColl == null) {
            relationsPermissionsColl = new RelationsPermissionsColl();
            return false;
        }
        return relationsPermissionsColl.hasPermission(relation, permission);
    }


    @Override
    public List<IPermission> getPermissionsOfRelation(IRelation relation) {
        if (relationsPermissionsColl == null) {
            relationsPermissionsColl = new RelationsPermissionsColl();
        }
        return relationsPermissionsColl.getPermissionsOfRelation(relation);
    }

    @Override
    public void addPermissionToRelation(IRelation relation, IPermission permission) {
        if (relationsPermissionsColl == null) {
            relationsPermissionsColl = new RelationsPermissionsColl();
        }
        relationsPermissionsColl.add(relation, permission);
    }

    @Override
    public void removePermissionFromRelation(IRelation relation, IPermission permission) {
        if (relationsPermissionsColl == null) {
            relationsPermissionsColl = new RelationsPermissionsColl();
        }
        relationsPermissionsColl.remove(relation, permission);
    }

    @Override
    public int getMaxPlayers() {
        return maxPlayers;
    }

    @Override
    public void setMaxPlayers(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    @Override
    public boolean canEnterNewPlayers() {
        return this.maxPlayers <= fPlayersUUIDs.getfPlayers().size();
    }

    @Override
    public long getTnTInBank() {
        return tnt;
    }

    @Override
    public void setTnTInBank(long amount) {
        this.tnt = amount;
    }

    @Override
    public void removeTnTFromBank(long amount) {
        Bukkit.getPluginManager().callEvent(new FactionsRemoveTnTFromBankEvent(this, amount));
    }

    @Override
    public void addTnTToBank(long amount) {
        Bukkit.getPluginManager().callEvent(new FactionsAddTnTToBankEvent(this, amount));
    }

    @Override
    public void clearTnTBank() {
        Bukkit.getPluginManager().callEvent(new FactionsRemoveTnTFromBankEvent(this, tnt));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Faction faction = (Faction) o;
        return id == faction.id;
    }

    @Override
    public int hashCode() {
        return (int) (name.hashCode() * id);
    }
}
