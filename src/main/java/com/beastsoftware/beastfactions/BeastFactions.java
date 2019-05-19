package com.beastsoftware.beastfactions;

import com.beastsoftware.beastfactions.api.IBeastFactionsInternalAPI;
import com.beastsoftware.beastfactions.api.IExternalAPI;
import com.beastsoftware.beastfactions.factions.command.IFactionsCommand;
import com.beastsoftware.beastfactions.injection.annotations.Fly;
import com.beastsoftware.beastfactions.manager.IManager;
import com.google.inject.Inject;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;


public final class BeastFactions extends JavaPlugin {

    @Inject
    private IFactionsCommand factionsCommand;

    @Inject
    private IBeastFactionsInternalAPI api;

    @Inject
    private IExternalAPI externalAPI;

    @Inject
    @Fly
    private IManager flyManager;

    private  static BeastFactions instance;

    public final static boolean debug = false;


    @Override
    public void onEnable() {
        instance = this;
        setUpCommands();
    }


    private void setUpCommands(){
        this.getCommand("f").setExecutor(this.factionsCommand);
        this.getCommand("f").setTabCompleter(this.factionsCommand);
        Bukkit.getLogger().info("BeastFactions > Commands loaded!");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        flyManager.removeAll();
    }

    public static BeastFactions getInstance() {
        return instance;
    }

    public IBeastFactionsInternalAPI getInternalApi() {
        return api;
    }

    public IExternalAPI getExternalAPI() {
        return externalAPI;
    }

    public boolean isOnSqlMode() {
        return false;
    }


}
