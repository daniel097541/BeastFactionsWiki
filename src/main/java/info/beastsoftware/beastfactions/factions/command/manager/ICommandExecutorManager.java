package info.beastsoftware.beastfactions.factions.command.manager;

import info.beastsoftware.beastfactions.factions.command.executor.IFactionSubCommand;

import java.util.List;

public interface ICommandExecutorManager {

    IFactionSubCommand getExecutorForCommand(String command);

    void addSubCommand(IFactionSubCommand commandExecutor);

    List<String> getSubCommands();
}
