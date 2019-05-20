package info.beastsoftware.beastfactions.factions.command;

import info.beastsoftware.beastfactions.factions.command.executor.IFactionSubCommand;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.TabCompleter;

public interface IFactionsCommand extends CommandExecutor, TabCompleter {

    void addSubCommand(IFactionSubCommand executor);

    IFactionSubCommand getExecutor(String command);

}
