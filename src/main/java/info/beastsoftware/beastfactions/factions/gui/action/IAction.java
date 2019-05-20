package info.beastsoftware.beastfactions.factions.gui.action;

import info.beastsoftware.beastfactions.factions.entity.IFPlayer;

public interface IAction {
    void doAction(IFPlayer player);

    boolean isDynamic();
}
