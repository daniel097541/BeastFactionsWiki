package com.beastsoftware.beastfactions.factions.task;

import com.beastsoftware.beastfactions.BeastFactions;
import com.beastsoftware.beastfactions.factions.entity.IFPlayer;
import org.bukkit.Bukkit;

public abstract class WarmUpTask implements IWarmUpTask {

    protected IFPlayer fPlayer;
    private int task;
    private int time;
    private BeastFactions plugin;


    public WarmUpTask(int time, BeastFactions plugin, IFPlayer fPlayer) {
        this.time = time;
        this.plugin = plugin;
        this.fPlayer = fPlayer;
    }

    @Override
    public void startTask() {
        this.task = Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, this, time * 20L);
    }

    @Override
    public void cancelTask() {
        Bukkit.getScheduler().cancelTask(this.task);
        callCancelEvent();
    }


    @Override
    public void run() {
        this.callEvent();
    }
}
