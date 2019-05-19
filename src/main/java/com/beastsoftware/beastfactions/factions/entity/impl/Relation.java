package com.beastsoftware.beastfactions.factions.entity.impl;

import com.beastsoftware.beastfactions.BeastFactions;
import com.beastsoftware.beastfactions.factions.entity.IChatMode;
import com.beastsoftware.beastfactions.factions.entity.IRelation;

import java.util.List;
import java.util.Objects;

public class Relation implements IRelation {


    private String name;
    private String colour;
    private List<String> blackListedCommands;
    private List<String> whiteListedCommands;
    private boolean defaultRelation;
    private boolean onBlackList;
    private boolean onWhiteList;
    private boolean allowTeleportInLand;
    private boolean blockPlaceAllowed;
    private boolean blockBreakAllowed;
    private boolean pvPAllowed;
    private String noPlaceMessage;
    private String noBreakMessage;
    private String noPvPMessage;
    private String noCommandUseMessage;
    private boolean cancelsFlight;
    private boolean requiresRequest;
    private final boolean isOwnFactionRelation;

    public Relation(String name, String colour, List<String> blackListedCommands, List<String> whiteListedCommands, boolean defaultRelation, boolean onBlackList, boolean onWhiteList, boolean allowTeleportInLand, boolean blockPlaceAllowed, boolean blockBreakAllowed, boolean pvPAllowed, String noPlaceMessage, String noBreakMessage, String noPvPMessage, String noCommandUseMessage,
                    boolean cancelsFlight, boolean requiresRequest, boolean isOwnFactionRelation) {
        this.name = name;
        this.colour = colour;
        this.blackListedCommands = blackListedCommands;
        this.whiteListedCommands = whiteListedCommands;
        this.defaultRelation = defaultRelation;
        this.onBlackList = onBlackList;
        this.onWhiteList = onWhiteList;
        this.allowTeleportInLand = allowTeleportInLand;
        this.blockPlaceAllowed = blockPlaceAllowed;
        this.blockBreakAllowed = blockBreakAllowed;
        this.pvPAllowed = pvPAllowed;
        this.noPlaceMessage = noPlaceMessage;
        this.noBreakMessage = noBreakMessage;
        this.noPvPMessage = noPvPMessage;
        this.noCommandUseMessage = noCommandUseMessage;
        this.cancelsFlight = cancelsFlight;
        this.requiresRequest = requiresRequest;
        this.isOwnFactionRelation = isOwnFactionRelation;
    }


    @Override
    public String getColour() {
        return colour;
    }

    @Override
    public List<String> getBlackListedCommands() {
        return blackListedCommands;
    }

    @Override
    public List<String> getWhiteListedCommands() {
        return whiteListedCommands;
    }

    @Override
    public boolean isDefaultRelation() {
        return defaultRelation;
    }

    @Override
    public boolean isOnBlackList() {
        return onBlackList;
    }

    @Override
    public boolean isOnWhiteList() {
        return onWhiteList;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isAllowTeleportInLand() {
        return allowTeleportInLand;
    }

    @Override
    public boolean isBlockPlaceAllowed() {
        return blockPlaceAllowed;
    }

    @Override
    public boolean isBlockBreakAllowed() {
        return blockBreakAllowed;
    }

    @Override
    public boolean isPvPAllowed() {
        return pvPAllowed;
    }

    @Override
    public String getNoPlaceMessage() {
        return noPlaceMessage;
    }

    @Override
    public String getNoBreakMessage() {
        return noBreakMessage;
    }

    @Override
    public String getNoPvPMessage() {
        return noPvPMessage;
    }

    @Override
    public String getNoCommandUseMessage() {
        return noCommandUseMessage;
    }

    @Override
    public boolean requiresRequest() {
        return requiresRequest;
    }

    @Override
    public boolean hasChatMode() {
        return BeastFactions.getInstance().getInternalApi().relationHasChatMode(this);
    }

    @Override
    public IChatMode getChatMode() {
        return BeastFactions.getInstance().getInternalApi().getChatModeOfRelation(this);
    }

    @Override
    public boolean cancelsFlight() {
        return cancelsFlight;
    }

    @Override
    public String getNameWithColor() {
        return getColour() + getName();
    }

    @Override
    public boolean isOwnFactionRelation() {
        return isOwnFactionRelation;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Relation relation = (Relation) o;
        return defaultRelation == relation.defaultRelation &&
                onBlackList == relation.onBlackList &&
                onWhiteList == relation.onWhiteList &&
                allowTeleportInLand == relation.allowTeleportInLand &&
                blockPlaceAllowed == relation.blockPlaceAllowed &&
                blockBreakAllowed == relation.blockBreakAllowed &&
                pvPAllowed == relation.pvPAllowed &&
                cancelsFlight == relation.cancelsFlight &&
                requiresRequest == relation.requiresRequest &&
                name.equals(relation.name) &&
                Objects.equals(colour, relation.colour) &&
                Objects.equals(blackListedCommands, relation.blackListedCommands) &&
                Objects.equals(whiteListedCommands, relation.whiteListedCommands) &&
                Objects.equals(noPlaceMessage, relation.noPlaceMessage) &&
                Objects.equals(noBreakMessage, relation.noBreakMessage) &&
                Objects.equals(noPvPMessage, relation.noPvPMessage) &&
                Objects.equals(noCommandUseMessage, relation.noCommandUseMessage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, colour, blackListedCommands, whiteListedCommands, defaultRelation, onBlackList, onWhiteList, allowTeleportInLand, blockPlaceAllowed, blockBreakAllowed, pvPAllowed, noPlaceMessage, noBreakMessage, noPvPMessage, noCommandUseMessage, cancelsFlight, requiresRequest);
    }
}
