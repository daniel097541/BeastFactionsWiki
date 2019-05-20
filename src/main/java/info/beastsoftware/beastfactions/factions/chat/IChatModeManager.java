package info.beastsoftware.beastfactions.factions.chat;

import info.beastsoftware.beastfactions.factions.entity.IChatMode;
import info.beastsoftware.beastfactions.factions.entity.IRelation;

public interface IChatModeManager {


    IChatMode getChatModeOfRelation(IRelation relation);

    boolean relationHasChatMode(IRelation relation);

}
