package com.beastsoftware.beastfactions.factions.entity.impl;

import com.beastsoftware.beastfactions.BeastFactions;
import com.beastsoftware.beastfactions.factions.entity.IChatMode;
import com.beastsoftware.beastfactions.factions.entity.IRelation;

public class ChatMode implements IChatMode {

    private String relationTalkingTo;
    private String format;
    private String prefix;
    private String sufix;


    public ChatMode(IRelation relationTalkingTo, String format, String prefix, String sufix) {
        this.relationTalkingTo = relationTalkingTo.getName();
        this.format = format;
        this.prefix = prefix;
        this.sufix = sufix;
    }

    @Override
    public IRelation getRelationTalkingTo() {
        return BeastFactions.getInstance().getInternalApi().getRelation(relationTalkingTo);
    }

    @Override
    public String getFormat() {
        return format;
    }

    @Override
    public String getPrefix() {
        return prefix;
    }

    @Override
    public String getSufix() {
        return sufix;
    }
}
