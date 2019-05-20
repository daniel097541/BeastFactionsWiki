package info.beastsoftware.beastfactions.factions.gui.controller;


import info.beastsoftware.beastfactions.BeastFactions;
import info.beastsoftware.beastfactions.factions.entity.IFPlayer;
import info.beastsoftware.beastfactions.factions.entity.IFaction;
import info.beastsoftware.beastfactions.factions.gui.entity.gui.IFactionsGUI;
import info.beastsoftware.beastfactions.factions.gui.event.GUIOpenEvent;
import info.beastsoftware.beastfactions.factions.gui.service.IFactionsGUIService;
import info.beastsoftware.beastfactions.factions.gui.struct.GUIType;

public abstract class FactionsGUIController implements IFactionsGUIController {


    protected final BeastFactions plugin;
    private final IFactionsGUIService guiService;


    FactionsGUIController(BeastFactions plugin, IFactionsGUIService guiService) {
        this.plugin = plugin;
        this.guiService = guiService;
        this.register();
    }

    @Override
    public void register() {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }


    @Override
    public void callOpenGUI(GUIOpenEvent event, Object target) {
        if (event.isCancelled()) return;

        int page = event.getPage();
        IFaction faction = event.getFaction();
        GUIType type = event.getType();
        IFPlayer player = event.getfPlayer();
        openGUI(player, faction, type, page, target);
    }

    @Override
    public void openGUI(IFPlayer player, IFaction faction, GUIType type, int page, Object target) {
        IFactionsGUI gui = guiService.getGuiOfType(faction, type, target);
        if (gui.getSize() - 1 < page || page < 0) return;
        //open the gui
        player.openGUI(gui, page);

    }


}
