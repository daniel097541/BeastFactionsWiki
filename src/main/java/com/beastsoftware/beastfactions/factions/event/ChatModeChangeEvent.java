package com.beastsoftware.beastfactions.factions.event;

import com.beastsoftware.beastfactions.factions.entity.IChatMode;
import com.beastsoftware.beastfactions.factions.entity.IFPlayer;

public class ChatModeChangeEvent extends FPlayerAbstractEvent {

    private IChatMode chatMode;

    public ChatModeChangeEvent(IFPlayer fPlayer, IChatMode chatMode) {
        super(fPlayer);
        this.chatMode = chatMode;
    }

    public IChatMode getChatMode() {
        return chatMode;
    }
}
