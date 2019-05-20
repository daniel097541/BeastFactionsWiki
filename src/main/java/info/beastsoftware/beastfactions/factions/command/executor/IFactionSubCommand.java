package info.beastsoftware.beastfactions.factions.command.executor;

import info.beastsoftware.beastfactions.factions.entity.IFPlayer;
import org.bukkit.command.CommandSender;

import java.util.List;

public interface IFactionSubCommand {

    void validate(CommandSender sender, String[] args);

    void execute(CommandSender sender, IFPlayer fPlayer, String[] args);

    void sendFormats(CommandSender sender);

    void sendNoPermission(CommandSender sender);

    boolean argsLengthMatches(int required, String args[]);

    void sendNoFaction(CommandSender sender);

    void sendFactionDoesNotExist(CommandSender sender, String factionName);

    String getCommand();

    List<String> getAliases();

    boolean isCommand(String command);

    void addAlias(String alias);

    boolean isEnabled();

    void toggle();

}
