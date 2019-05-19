package com.beastsoftware.beastfactions.factions.relation;

import com.beastsoftware.beastfactions.factions.entity.IFaction;
import com.beastsoftware.beastfactions.factions.entity.IRelation;
import com.beastsoftware.beastfactions.factions.entity.IRelationRequest;
import com.beastsoftware.beastfactions.factions.entity.impl.Relation;
import com.beastsoftware.beastfactions.injection.annotations.MainConfiguration;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import config.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Singleton
public class RelationManager implements IRelationManager {

    private final IConfig config;
    private final List<IRelation> relations;
    private volatile List<IRelationRequest> requests;

    @Inject
    public RelationManager(@MainConfiguration IConfig config) {
        this.requests = new ArrayList<>();
        this.config = config;
        this.relations = new ArrayList<>();
        this.loadRelations();
    }

    @Override
    public IRelation getDefaultRelation() {
        for (IRelation relation : relations)
            if (relation.isDefaultRelation())
                return relation;
        return null;
    }

    @Override
    public void loadRelations() {
        String path = "Configuration.Factions.Relations.default-faction-relations.";
        for (String section : config.getConfig().getConfigurationSection(path).getKeys(false)) {
            String colour = config.getConfig().getString(path + section + ".colour");
            List<String> whitelisted = config.getConfig().getStringList(path + section + "settings.allowed-commands-in-land");
            List<String> blacklisted = config.getConfig().getStringList(path + section + "settings.blocked-commands-in-land");
            boolean whitelistMode = config.getConfig().getBoolean(path + section + "settings.command-whitelist-mode");
            boolean blacklistmode = config.getConfig().getBoolean(path + section + "settings.command-blacklist-mode");
            boolean allowTeleport = config.getConfig().getBoolean(path + section + "settings.allow-teleport-in-land");
            boolean isDefault = config.getConfig().getBoolean(path + section + ".default-relation");
            boolean blockBreakAllowed = config.getConfig().getBoolean(path + section + ".settings.allow-block-break");
            boolean blockPlaceAllowed = config.getConfig().getBoolean(path + section + ".settings.allow-build");
            boolean pvpAllowed = config.getConfig().getBoolean(path + section + ".settings.allow-pvp");
            String noPvPMessage = config.getConfig().getString(path + section + ".messages.deny-pvp-message");
            String noPlaceMessage = config.getConfig().getString(path + section + ".messages.deny-block-place-message");
            String noBreakMessage = config.getConfig().getString(path + section + ".messages.deny-block-break-message");
            String noCommandUse = config.getConfig().getString(path + section + ".messages.deny-command-message");
            boolean cancelsFlight = config.getConfig().getBoolean(path + section + ".cancel-fly-on-near-player");
            boolean requiresRequest = config.getConfig().getBoolean(path + section + ".requires-request");
            boolean isOwnFactionRelation = config.getConfig().isBoolean(path + section + ".is-own-faction-relation");
            IRelation relation = new Relation(section, colour, blacklisted, whitelisted, isDefault, blacklistmode, whitelistMode,
                    allowTeleport, blockPlaceAllowed, blockBreakAllowed, pvpAllowed, noPlaceMessage, noBreakMessage, noPvPMessage,
                    noCommandUse, cancelsFlight, requiresRequest, isOwnFactionRelation);
            this.relations.add(relation);
        }


    }

    @Override
    public List<IRelation> getRelations() {
        return relations;
    }

    @Override
    public IRelation getByName(String name) {

        return relations
                .parallelStream()
                .filter(rel -> rel.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }


    @Override
    public HashMap<String, List<Long>> serializeRelations() {

        HashMap<String, List<Long>> hashMap = new HashMap<>();

        for (IRelation relation : relations) {
            hashMap.put(relation.getName(), new ArrayList<>());
        }
        return hashMap;
    }

    @Override
    public void addRelationRequest(IRelationRequest relationRequest) {
        requests.add(relationRequest);
    }

    @Override
    public void removeRelationRequest(IFaction sender, IFaction target) {
        requests.removeIf(request -> request.getTarget().getId() == target.getId() && request.getSender().getId() == sender.getId());

    }

    @Override
    public IRelationRequest getRelationRequest(IFaction sender, IFaction target) {
        return requests
                .parallelStream()
                .filter(req -> req.getTarget().getId() == target.getId() && req.getSender().getId() == sender.getId())
                .findFirst()
                .orElse(null);
    }

    @Override
    public boolean requestExists(IFaction sender, IFaction target) {
        return requests
                .parallelStream()
                .anyMatch(req -> req.getTarget().getId() == target.getId() && req.getSender().getId() == sender.getId());
    }

    @Override
    public IRelation getOwnRelation() {
        return relations
                .parallelStream()
                .filter(IRelation::isOwnFactionRelation)
                .findFirst()
                .orElse(null);
    }
}
