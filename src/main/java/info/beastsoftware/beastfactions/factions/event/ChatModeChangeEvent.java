package info.beastsoftware.beastfactions.factions.event;

import info.beastsoftware.beastfactions.factions.entity.IChatMode;
import info.beastsoftware.beastfactions.factions.entity.IFPlayer;

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
