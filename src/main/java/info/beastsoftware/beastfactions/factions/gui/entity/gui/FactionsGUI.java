package info.beastsoftware.beastfactions.factions.gui.entity.gui;

import info.beastsoftware.beastfactions.factions.entity.IFaction;
import info.beastsoftware.beastfactions.factions.gui.entity.page.IPage;
import info.beastsoftware.beastfactions.factions.gui.struct.GUIType;

import java.util.List;

public abstract class FactionsGUI<T> extends AbstractGUI implements IFactionsGUI<T> {

    private final IFaction faction;

    public FactionsGUI(List<IPage> pages, IFaction faction, GUIType type, boolean mustBeStoredInCache) {
        super(pages, type, mustBeStoredInCache);
        this.faction = faction;
    }


    @Override
    public IFaction getFaction() {
        return faction;
    }
}
