package com.beastsoftware.beastfactions.factions.chat;

import com.beastsoftware.beastfactions.factions.entity.IChatMode;
import com.beastsoftware.beastfactions.factions.entity.IRelation;

public interface IChatModeManager {


    IChatMode getChatModeOfRelation(IRelation relation);

    boolean relationHasChatMode(IRelation relation);

}
