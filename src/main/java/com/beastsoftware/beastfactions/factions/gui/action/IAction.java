package com.beastsoftware.beastfactions.factions.gui.action;

import com.beastsoftware.beastfactions.factions.entity.IFPlayer;

public interface IAction {
    void doAction(IFPlayer player);

    boolean isDynamic();
}
