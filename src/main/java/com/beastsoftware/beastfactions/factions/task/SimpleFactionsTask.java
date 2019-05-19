package com.beastsoftware.beastfactions.factions.task;

import com.beastsoftware.beastfactions.BeastFactions;
import org.bukkit.Bukkit;

public abstract class SimpleFactionsTask implements ISimpleFactionsTask, Runnable {

    protected int task;
    private int time;
    protected BeastFactions plugin;

    public SimpleFactionsTask(int time, BeastFactions plugin) {
        this.time = time;
        this.plugin = plugin;
    }

    @Override
    public void startTask() {
        this.task = Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, this, time, time);
    }

    @Override
    public void cancelTask() {
        Bukkit.getScheduler().cancelTask(this.task);
    }

    @Override
    public void run() {
        callEvent();
    }
}
