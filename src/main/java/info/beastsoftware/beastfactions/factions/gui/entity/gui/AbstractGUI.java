package info.beastsoftware.beastfactions.factions.gui.entity.gui;

import info.beastsoftware.beastfactions.BeastFactions;
import info.beastsoftware.beastfactions.factions.entity.IFPlayer;
import info.beastsoftware.beastfactions.factions.gui.entity.page.IPage;
import info.beastsoftware.beastfactions.factions.gui.struct.GUIType;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class AbstractGUI implements IGUI {

    private final List<IPage> pages;
    private final GUIType type;
    private final boolean mustBeStoredInCache;
    private final List<IFPlayer> watchers;

    public AbstractGUI(List<IPage> pages, GUIType type, boolean mustBeStoredInCache) {
        this.pages = pages;
        this.type = type;
        this.mustBeStoredInCache = mustBeStoredInCache;
        this.watchers = new ArrayList<>();
    }


    @Override
    public GUIType getGuiType() {
        return type;
    }

    @Override
    public IPage getPage(int index) {
        for (IPage page : pages)
            if (page.getIndex() == index)
                return page;
        return null;
    }

    @Override
    public void loadGUI() {
        for (IPage page : pages)
            page.loadPage();
    }

    @Override
    public boolean isPage(Inventory inventory) {
        for (IPage page : pages)
            if (page.getInventory().equals(inventory))
                return true;
        return false;
    }

    @Override
    public IPage getPage(Inventory inventory) {
        for (IPage page : pages)
            if (page.getInventory().equals(inventory))
                return page;
        return null;
    }

    @Override
    public int getPageIndex(Inventory inventory) {
        return getPage(inventory).getIndex();
    }

    @Override
    public int getSize() {
        return pages.size();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractGUI gui = (AbstractGUI) o;
        return pages.equals(gui.pages);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pages);
    }

    @Override
    public void fillWithSpacers(ItemStack spacer) {
        for (IPage page : pages)
            page.fillWithSpacers(spacer);
    }

    @Override
    public boolean mustBeStoredInCache() {
        return mustBeStoredInCache;
    }

    @Override
    public List<IFPlayer> getWatchers() {

        List<IFPlayer> watchers = new ArrayList<>();

        for (IPage page : pages) {

            for (HumanEntity humanEntity : page.getInventory().getViewers()) {
                watchers.add(BeastFactions.getInstance().getInternalApi().getFPlayer((Player) humanEntity));
            }

        }

        return watchers;
    }

}
