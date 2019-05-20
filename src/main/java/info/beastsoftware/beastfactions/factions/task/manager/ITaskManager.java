package info.beastsoftware.beastfactions.factions.task.manager;

import info.beastsoftware.beastfactions.factions.task.ISimpleFactionsTask;
import info.beastsoftware.beastfactions.factions.task.IWarmUpTask;

public interface ITaskManager {


    ISimpleFactionsTask getPowerTask(String owner);

    void removePowerTask(String owner);

    void cancelPowerTask(String owner);

    void startPowerTask(String owner);

    void addPowerTask(String owner, ISimpleFactionsTask task);

    boolean powerTaskExists(String owner);


    IWarmUpTask getWarmUpTask(String owner);

    void cancelWarmUpTask(String owner);

    void removeWarmUpTask(String owner);

    void addAndStartWarmUpTask(String owner, IWarmUpTask warmUpTask);

    boolean warmUpTaskExists(String owner);



}
