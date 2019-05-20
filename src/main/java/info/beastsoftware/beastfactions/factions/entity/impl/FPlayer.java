package info.beastsoftware.beastfactions.factions.entity.impl;

import info.beastsoftware.beastfactions.BeastFactions;
import com.beastsoftware.beastfactions.factions.entity.*;
import com.beastsoftware.beastfactions.factions.event.*;
import info.beastsoftware.beastfactions.factions.entity.*;
import info.beastsoftware.beastfactions.factions.event.*;
import info.beastsoftware.beastfactions.factions.event.callback.GetFactionCallBackEvent;
import info.beastsoftware.beastfactions.factions.event.callback.GetRelationCallBackEvent;
import info.beastsoftware.beastfactions.factions.gui.entity.gui.IGUI;
import info.beastsoftware.beastfactions.factions.gui.entity.page.IPage;
import info.beastsoftware.beastfactions.factions.struct.FactionPerm;
import info.beastsoftware.beastfactions.hook.IHookManager;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import utils.StrUtils;

import java.util.*;

public class FPlayer implements IFPlayer {


    private String name;
    private String uuid;
    private int power;
    private int maxPower;
    private long factionId;
    private String role;
    private IPermissionsColl permissions;
    private IChatMode chatMode;
    private int mapSize;



    public FPlayer(Player player, int maxPower) {
        this.name = player.getName();
        this.uuid = player.getUniqueId().toString();
        this.power = 0;
        this.maxPower = maxPower;
        this.permissions = new PermissionsColl();
    }

    public FPlayer() {
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public UUID getUuid() {
        return UUID.fromString(uuid);
    }

    @Override
    public int getPower() {
        return power;
    }

    @Override
    public int getMaxPower() {
        return maxPower;
    }

    @Override
    public Player getPlayer() {
        Player player = Bukkit.getPlayer(getUuid());
        if (player == null)
            player = Bukkit.getPlayer(getName());
        return player;
    }

    @Override
    public OfflinePlayer getOfflinePlayer() {
        return Bukkit.getOfflinePlayer(UUID.fromString(uuid));
    }

    @Override
    public boolean isOnline() {
        return getPlayer() != null;
    }

    @Override
    public void setPower(int power) {
        this.power = power;
    }

    @Override
    public void setMaxPower(int maxPower) {
        this.maxPower = maxPower;
    }

    @Override
    public IFaction getFaction() {

        GetFactionCallBackEvent event = new GetFactionCallBackEvent(this.factionId);
        Bukkit.getPluginManager().callEvent(event);

        return event.getFaction();
    }

    @Override
    public long getFactionId() {
        return factionId;
    }

    @Override
    public void setFactionId(long factionId) {
        this.factionId = factionId;
        this.permissions = new PermissionsColl();
    }

    @Override
    public boolean hasFaction() {
        return !isFactionLess();
    }

    @Override
    public boolean isOwner() {
        return hasFaction() && getFaction().getOwner().equals(this);
    }

    @Override
    public IFactionRole getRole() {
        if (!hasFaction()) return null;
        return getFaction().getFactionRole(role);
    }

    @Override
    public void setRole(IFactionRole role) {
        if (role == null) this.role = "";
        else
            this.role = role.getRoleName();
    }

    @Override
    public boolean hasPermission(FactionPerm permission) {
        if (isOwner()) return true;
        if (isOnline() && isAdminBypassing()) return true;
        if (!hasFaction()) return false;

        IPermission perm = new Permission(permission.toString());
        IPermission all = new Permission("ALL");

        if (getRole().hasPermission(all)) return true;
        if (hasPermissionAsPlayer(all)) return true;

        return getRole().hasPermission(perm)
                || hasPermissionAsPlayer(perm)
                || isOwner();
    }

    @Override
    public void addPermissionAsPlayer(IPermission permission) {
        if (permissions == null)
            permissions = new PermissionsColl();
        permissions.add(permission);
    }

    @Override
    public void removePermissionAsPlayer(IPermission permission) {
        permissions.remove(permission);
    }

    @Override
    public boolean hasPermissionAsPlayer(IPermission permission) {
        if (isOnline() && isAdminBypassing()) return true;
        if (permissions == null) return false;
        return permissions.contains(permission);
    }

    @Override
    public List<IPermission> getPermissionsAsPlayer() {
        return permissions.getPermissions();
    }

    @Override
    public IRelation getRelationWith(IFPlayer player) {

        if (!this.hasFaction() || !player.hasFaction()) {
            GetRelationCallBackEvent event = new GetRelationCallBackEvent(true);
            Bukkit.getPluginManager().callEvent(event);
            return event.getRelation();
        }

        return this.getFaction().getRelationWith(player.getFaction());
    }

    @Override
    public IRelation getRelationWithFaction(IFaction faction) {
        return getFaction().getRelationWith(faction);
    }

    @Override
    public boolean isInFaction(IFaction faction) {
        return this.getFactionId() == faction.getId();
    }

    @Override
    public IFaction getFactionWhereIAm() {
        if (this.isOnline()) {
            GetFactionCallBackEvent event = new GetFactionCallBackEvent(getPlayer().getLocation());
            Bukkit.getPluginManager().callEvent(event);
            return event.getFaction();
        }
        return null;
    }

    @Override
    public IFPlayer getNearbiestPlayerInRadius(int radius) {
        java.util.Map.Entry<Integer, IFPlayer> nearbiest = null;

        for (IFPlayer player : BeastFactions.getInstance().getInternalApi().getAllOnlinePlayers()) {
            int distance = player.getLocation().distanceTo(getLocation());

            if (distance <= radius) {
                if (nearbiest == null || nearbiest.getKey() > distance)
                    nearbiest = new AbstractMap.SimpleImmutableEntry<>(distance, player);

            }
        }

        if (nearbiest == null) return null;

        return nearbiest.getValue();
    }

    @Override
    public List<IFPlayer> getAllNearbyFPlayersInRadius(int radius) {
        List<Entity> nearbyEntities = this.getPlayer().getNearbyEntities(radius, radius, radius);
        List<IFPlayer> nearbyPlayers = new ArrayList<>();
        for (Entity entity : nearbyEntities) {
            if (!(entity instanceof Player)) continue;
            Player nearby = (Player) entity;
            nearbyPlayers.add(BeastFactions.getInstance().getInternalApi().getFPlayer(nearby));
        }
        return nearbyPlayers;
    }

    @Override
    public boolean isFlying() {
        return BeastFactions.getInstance().getInternalApi().isFlying(this);
    }

    @Override
    public void toggleFlight() {
        Bukkit.getScheduler().runTask(BeastFactions.getInstance(), () -> Bukkit.getPluginManager().callEvent(new ToggleFlightEvent(this)));
    }

    @Override
    public boolean canEnableFlightDueNearbyPlayers(int radius) {

        for (IFPlayer ifPlayer : this.getAllNearbyFPlayersInRadius(radius)) {
            IRelation relation = this.getRelationWith(ifPlayer);
            if (relation.cancelsFlight()) {
                return false;
            }
        }

        return true;
    }

    @Override
    public IFPlayer getNearbyPlayerInRadiusWithRelation(int radius, IRelation relation) {
        List<Entity> nearbyEntities = this.getPlayer().getNearbyEntities(radius, radius, radius);
        for (Entity entity : nearbyEntities) {
            if (!(entity instanceof Player)) continue;
            Player nearby = (Player) entity;
            IFPlayer nearbyFPlayer = BeastFactions.getInstance().getInternalApi().getFPlayer(nearby);
            if (relation.equals(nearbyFPlayer.getRelationWith(this)))
                return nearbyFPlayer;
        }
        return null;
    }


    @Override
    public void save() {
        Bukkit.getPluginManager().callEvent(new FPlayerSaveEvent(null, this));
    }

    @Override
    public void setRoleName(String role) {
        this.role = role;
    }

    @Override
    public void setUUID(UUID uuid) {
        this.uuid = uuid.toString();
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean canBypassWarmUps() {
        if (getPlayer() == null) return false;
        return getPlayer().hasPermission("beastfactions.warmup.bypass");
    }

    @Override
    public void setPermissions(List<IPermission> permissions) {
        this.permissions = new PermissionsColl(permissions);
    }

    @Override
    public IPermissionsColl getPermissionsColl() {
        return permissions;
    }

    @Override
    public void setPermissionsColl(PermissionsColl permissionsColl) {
        this.permissions = permissionsColl;
    }

    @Override
    public void sms(String message) {
        if (getPlayer() != null)
            StrUtils.sms(getPlayer(), message);
    }

    @Override
    public IChatMode getChatMode() {
        return this.chatMode;
    }

    @Override
    public void setChatMode(IChatMode chatMode) {
        this.chatMode = chatMode;
    }

    @Override
    public boolean hasPermission(IPermission permission) {
        if (isOwner()) return true;
        if (isOnline() && getPlayer().isOp()) return true;
        if (!hasFaction()) return false;
        if (getRole().hasPermission(new Permission("ALL"))) return true;
        if (hasPermissionAsPlayer(new Permission("ALL"))) return true;
        return getRole().hasPermission(permission) || hasPermissionAsPlayer(permission);
    }

    @Override
    public boolean isUnclaimingAll() {
        return BeastFactions.getInstance().getInternalApi().isUnclaimingAll(this);
    }

    @Override
    public void startUnclaimingAll() {
        BeastFactions.getInstance().getInternalApi().addUnclaimingAll(this);
    }

    @Override
    public void stopUnclaimingAll() {
        BeastFactions.getInstance().getInternalApi().removeUnclaimingAll(this);
    }

    @Override
    public boolean isDisbanding() {
        return BeastFactions.getInstance().getInternalApi().isConfirmingDisband(this);
    }

    @Override
    public void startDisbanding() {
        if (!isDisbanding())
            Bukkit.getPluginManager().callEvent(new DisbandConfirmationToggleEvent(this));
    }

    @Override
    public void stopDisbanding() {
        if (isDisbanding())
            Bukkit.getPluginManager().callEvent(new DisbandConfirmationToggleEvent(this));
    }

    @Override
    public boolean hasFallDamage() {
        return BeastFactions.getInstance().getInternalApi().hasFallDamage(this);
    }

    @Override
    public void disableFallDamage() {
        Bukkit.getPluginManager().callEvent(new ToggleFallDamageEvent(this));
    }

    @Override
    public void enableFallDamage() {
        if (!hasFallDamage())
            Bukkit.getPluginManager().callEvent(new ToggleFallDamageEvent(this));
    }


    @Override
    public Location getHomeLocation() {
        if (!hasFaction()) return null;
        return getFaction().getHomeLocation();
    }

    @Override
    public boolean isInOwnLand() {
        if (!isOnline()) return false;
        if (!hasFaction()) return false;
        return getFaction().isClaim(getPlayer().getLocation());
    }

    @Override
    public boolean isAutoClaiming() {
        return BeastFactions.getInstance().getInternalApi().isAutoClaiming(this);
    }

    @Override
    public void stopAutoClaiming() {
        if (!this.isAutoClaiming()) return;

        ToggleAutoClaimEvent event = new ToggleAutoClaimEvent(this);
        Bukkit.getPluginManager().callEvent(event);
    }

    @Override
    public void startAutoClaiming() {
        if (this.isAutoClaiming()) return;

        ToggleAutoClaimEvent event = new ToggleAutoClaimEvent(this);
        Bukkit.getPluginManager().callEvent(event);
    }

    @Override
    public int getPriority() {
        if (!hasFaction())
            return -1;
        return getRole().getPriority();
    }

    @Override
    public boolean hasMorePriorityThan(IFPlayer otherPlayer) {
        if (otherPlayer.isOwner()) return false;
        if (this.isOwner()) return true;
        return getPriority() > otherPlayer.getPriority();
    }

    @Override
    public int getMapSize() {
        return mapSize;
    }

    @Override
    public void setMapSize(int mapSize) {
        this.mapSize = mapSize;
    }

    @Override
    public IMap getMapAround(int mapSize) {
        IFactionsLocation location = getLocation();
        if (location == null) return null;
        return new Map(mapSize, location);
    }

    @Override
    public IFactionsLocation getLocation() {
        if (!isOnline()) return null;
        return new FactionsLocation(getPlayer().getLocation());
    }

    @Override
    public boolean isWatchingMap() {
        return BeastFactions.getInstance().getInternalApi().isWatchingMap(this);
    }

    @Override
    public void startWatchingMap() {
        if (!isWatchingMap())
            Bukkit.getPluginManager().callEvent(new MapToggleEvent(this));
    }

    @Override
    public void stopWatchingMap() {
        if (isWatchingMap())
            Bukkit.getPluginManager().callEvent(new MapToggleEvent(this));
    }

    @Override
    public void sendMap(int mapSize) {
        SendMapEvent event = new SendMapEvent(this, mapSize);
        Bukkit.getPluginManager().callEvent(event);
    }

    @Override
    public boolean isFactionLess() {
        return getFaction().isFactionless();
    }

    @Override
    public double getMoney() {
        IHookManager hookManager = BeastFactions.getInstance().getInternalApi().getHookManager();
        if (hookManager.isEconomyHooked())
            return hookManager.getEconomyHook().getMoney(this);
        return 0;
    }

    @Override
    public double setMoney(double money) {
        IHookManager hookManager = BeastFactions.getInstance().getInternalApi().getHookManager();
        if (hookManager.isEconomyHooked()) {
            hookManager.getEconomyHook().setMoney(this, money);
            return this.getMoney();
        }
        return 0;
    }

    @Override
    public void clearMoney() {
        IHookManager hookManager = BeastFactions.getInstance().getInternalApi().getHookManager();
        if (hookManager.isEconomyHooked()) {
            hookManager.getEconomyHook().clearMoney(this);
        }
    }

    @Override
    public double addMoney(double money) {
        IHookManager hookManager = BeastFactions.getInstance().getInternalApi().getHookManager();
        if (hookManager.isEconomyHooked()) {
            hookManager.getEconomyHook().giveMoney(this, money);
            return this.getMoney();
        }
        return 0;
    }

    @Override
    public void takeMoney(double money) {
        IHookManager hookManager = BeastFactions.getInstance().getInternalApi().getHookManager();
        if (hookManager.isEconomyHooked()) {
            hookManager.getEconomyHook().takeMoney(this, money);
        }
    }

    @Override
    public boolean isAdminBypassing() {
        return BeastFactions.getInstance().getInternalApi().isBypassing(this);
    }

    @Override
    public void startAdminBypassing() {
        if (!isAdminBypassing())
            Bukkit.getPluginManager().callEvent(new ToggleAdminBypassEvent(this));
    }

    @Override
    public void stopAdminBypassing() {
        if (isAdminBypassing())
            Bukkit.getPluginManager().callEvent(new ToggleAdminBypassEvent(this));
    }

    @Override
    public List<IFPlayer> getNearbyPlayersOfSameFaction(int radius) {

        List<IFPlayer> players = new ArrayList<>();
        for (IFPlayer player : getFaction().getOnlineFPlayers()) {
            if (player.equals(this)) continue;
            if (player.getLocation().distanceTo(getLocation()) <= radius)
                players.add(player);
        }

        return players;
    }

    @Override
    public boolean isSeeingChunk() {
        return BeastFactions.getInstance().getInternalApi().isSeeingChunk(this);
    }

    @Override
    public void startSeeingChunk() {
        if (isSeeingChunk()) return;
        Bukkit.getPluginManager().callEvent(new ToggleSeeChunkEvent(this));
    }

    @Override
    public void stopSeeingChunk() {
        if (!isSeeingChunk()) return;
        Bukkit.getPluginManager().callEvent(new ToggleSeeChunkEvent(this));
    }

    @Override
    public IFChunk getChunkWhereIAm() {

        if (!isOnline())
            return null;

        Player player = getPlayer();

        return new FChunk(player.getLocation().getChunk());
    }

    @Override
    public void load() {

    }

    @Override
    public void unLoad() {

    }


    @Override
    public void changedLandEvent(IFaction from, IFaction to) {
        Bukkit.getPluginManager().callEvent(new FPlayerChangedLandEvent(this, from, to));
    }


    @Override
    public void sendTopProgress(int record, IFaction faction) {
        Bukkit.getPluginManager().callEvent(new SendTopProgressEvent(this,record,faction));
    }

    @Override
    public void depositMoney(IFaction faction, long amount) {
        FPlayerDepositedMoneyEvent event = new FPlayerDepositedMoneyEvent(this, faction, amount);
        Bukkit.getPluginManager().callEvent(event);
    }

    @Override
    public void withdrawMoney(IFaction faction, long amount) {
        FactionWithdrawMoneyEvent event = new FactionWithdrawMoneyEvent(this, faction, amount);
        Bukkit.getPluginManager().callEvent(event);
    }


    @Override
    public boolean canFlyInFaction(IFaction faction) {

        if (isAdminBypassing()) return true;

        if (faction.isDefaultFaction()) {
            IDefaultFaction defaultFaction = (IDefaultFaction) faction;
            return defaultFaction.allowsFly();
        }
        IRelation relation = faction.getRelationWith(getFaction());
        return !relation.cancelsFlight();
    }


    @Override
    public boolean hasPermissionToFly() {
        return hasPermission(FactionPerm.FLY);
    }


    @Override
    public void sendTitle(String title, int fadeIn, int stay, int fadeOut) {
        if (!this.isOnline()) return;
        StrUtils.sendTitle(title, 10, 25, 10, this.getPlayer());
    }

    @Override
    public boolean isInFactionsLand(IFaction faction) {
        return getFactionWhereIAm().equals(faction);
    }

    @Override
    public void openGUI(IGUI gui, int page) {
        Bukkit.getScheduler().runTask(BeastFactions.getInstance(), () -> {
            if (!isOnline()) return;
            Player player = getPlayer();
            IPage iPage = gui.getPage(page);
            Inventory inventory = iPage.getInventory();
            player.openInventory(inventory);
        });
    }

    @Override
    public void closeGUI() {
        if (!isOnline()) return;
        getPlayer().closeInventory();
    }

    @Override
    public int getAmountOfTnTInInventory() {
        if (!isOnline())
            return 0;

        int amount = 0;

        for (ItemStack itemStack : getPlayer().getInventory()) {
            if (itemStack == null) continue;
            if (itemStack.getType().equals(Material.TNT))
                amount += itemStack.getAmount();
        }

        return amount;
    }


    @Override
    public void clearTnTFromInventory(int amount) {
        if (!isOnline()) return;


        int cleared = 0;

        Inventory inventory = getPlayer().getInventory();
        int slot = 0;

        for (ItemStack itemStack : inventory) {

            if (amount == cleared) return;


            if (itemStack == null) {
                slot++;
                continue;
            }

            if (!itemStack.getType().equals(Material.TNT)) {
                slot++;
                continue;
            }

            int stackSize = itemStack.getAmount();

            if (amount - cleared < stackSize) {
                itemStack.setAmount(stackSize - (amount - cleared));
                cleared = amount;
                slot++;
            } else {
                inventory.setItem(slot, null);
                slot++;
                cleared += stackSize;
            }

        }

    }


    @Override
    public int getFreeSlotsInInventory() {
        if (!isOnline()) return 0;

        int free = 0;

        for (ItemStack itemStack : getPlayer().getInventory()) {
            if (itemStack == null) {
                free++;
                continue;
            }

            if (itemStack.getType().equals(Material.AIR)) free++;
        }


        return free;
    }

    @Override
    public void addTnTToInventory(int amount) {
        if (!isOnline()) return;

        int freeSlots = getFreeSlotsInInventory();
        int dropped = 0;


        if (freeSlots * 64 < amount) {
            dropped = amount - (freeSlots * 64);
        }


        if (dropped != 0) {
            getPlayer().getInventory().addItem(new ItemStack(Material.TNT, amount - dropped));
            getPlayer().getLocation().getWorld().dropItem(getLocation().getLocation(), new ItemStack(Material.TNT, dropped));
        } else {
            getPlayer().getInventory().addItem(new ItemStack(Material.TNT, amount));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FPlayer fPlayer = (FPlayer) o;
        return factionId == fPlayer.factionId &&
                Objects.equals(name, fPlayer.name) &&
                Objects.equals(uuid, fPlayer.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, uuid);
    }
}
