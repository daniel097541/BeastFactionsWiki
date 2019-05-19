package com.beastsoftware.beastfactions.factions.gui.factory;

import com.beastsoftware.beastfactions.factions.entity.IFaction;
import com.beastsoftware.beastfactions.factions.gui.entity.button.IButton;
import com.beastsoftware.beastfactions.factions.gui.entity.gui.IFactionsGUI;
import com.beastsoftware.beastfactions.factions.gui.entity.page.IPage;
import com.beastsoftware.beastfactions.factions.gui.struct.GUIType;

public interface IFactionsGUIFactory<T> {

    IFactionsGUI build(GUIType type, IFaction faction, T target);

    void realTimeUpdateButton(GUIType type, IFaction faction, IButton button, IFactionsGUI gui, IPage page, T target);
}
