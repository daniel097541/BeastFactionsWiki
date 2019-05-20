package info.beastsoftware.beastfactions.factions.command.executor;

import info.beastsoftware.beastfactions.BeastFactions;
import info.beastsoftware.beastfactions.factions.entity.IFPlayer;
import info.beastsoftware.beastfactions.factions.entity.IPermission;
import info.beastsoftware.beastfactions.factions.struct.FCommandType;
import config.IConfig;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import utils.StrUtils;

import java.util.ArrayList;
import java.util.List;


public abstract class FSubCommand implements IFactionSubCommand {


    protected BeastFactions plugin;
    private String commandName;
    protected String path = "Commands.Faction-{name}-Command.";
    protected FCommandType commandType;
    private List<String> aliases;
    protected String command;
    protected boolean async;
    protected YamlConfiguration commandConfig;
    private boolean mustHaveFaction;
    private boolean mustHavePermission;
    protected IPermission permission;
    protected boolean enabled;

    public FSubCommand(BeastFactions plugin, IConfig config, String commandName, boolean async) {
        this.plugin = plugin;
        this.commandName = commandName;
        this.path = path.replace("{name}", commandName);
        this.aliases = new ArrayList<>();
        this.command = commandName;
        this.async = async;
        this.commandConfig = config.getConfig();
    }


    public FSubCommand(BeastFactions plugin, IConfig config, FCommandType commandType, boolean async, boolean mustHaveFaction, boolean mustHavePermission, IPermission permission) {
        this.plugin = plugin;
        this.commandType = commandType;
        this.commandName = commandType.getCommandName();
        this.path = path.replace("{name}", commandName);
        this.commandConfig = config.getConfig();
        this.aliases = new ArrayList<>();
        this.command = commandName;
        this.async = async;
        this.mustHavePermission = mustHavePermission;
        this.mustHaveFaction = mustHaveFaction;
        this.permission = permission;
        enabled = commandConfig.getBoolean(path + "enabled");

    }


    public void addAlias(String alias) {
        this.aliases.add(alias);
    }

    @Override
    public void sendFormats(CommandSender sender) {
        String formatsMessage = commandConfig.getString(path + "format");
        if (formatsMessage != null)
            StrUtils.sms(sender, formatsMessage);
    }


    @Override
    public void sendNoPermission(CommandSender sender) {

        String noPermissionMessage = commandConfig.getString(path + "no-permission-message");
        if (noPermissionMessage != null)
            StrUtils.sms(sender, noPermissionMessage);
    }


    @Override
    public void sendNoFaction(CommandSender playerSender) {
        String message = commandConfig.getString(path + "you-dont-have-faction");
        if (message != null)
            StrUtils.sms(playerSender, message);
    }

    @Override
    public void sendFactionDoesNotExist(CommandSender sender, String factionName) {
        String message = commandConfig.getString(path + "faction-does-not-exist");
        if (message != null) {
            message = StrUtils.replacePlaceholder(message, "{faction_name}", factionName);
            StrUtils.sms(sender, message);
        }
    }

    @Override
    public boolean argsLengthMatches(int required, String[] args) {
        return args.length == required;
    }

    @Override
    public void validate(CommandSender sender, String[] args) {

        long s = System.currentTimeMillis();

        Player player = (Player) sender;
        IFPlayer fPlayer = BeastFactions.getInstance().getInternalApi().getFPlayer(player);

        //if the command is native
        if (commandType != null) {

            //send formats
            if (commandType.checkArgs() && !argsLengthMatches(commandType.getRequiredArgs(), args)) {
                sendFormats(sender);
                return;
            }


            //must have faction
            if (mustHaveFaction && !fPlayer.hasFaction()) {
                sendNoFaction(sender);
                return;
            }


            //must have permission
            if (mustHavePermission && !fPlayer.hasPermission(permission)) {
                sendNoPermission(sender);
                return;
            }


        }


        if (async)
            /////////// **** ASYNC COMMAND EXECUTION *** /////////////////////
            Bukkit.getScheduler().runTaskAsynchronously(plugin, () -> execute(sender, fPlayer, args));
            /////////// **** ASYNC COMMAND EXECUTION *** /////////////////////
        else this.execute(sender, fPlayer, args);

        long e = System.currentTimeMillis();


        //debug mode to check the performance of the commands (ASYNC ones will always show 0)
        if (BeastFactions.debug)
            Bukkit.broadcastMessage(e - s + "");

    }


    @Override
    public List<String> getAliases() {
        return aliases;
    }

    @Override
    public String getCommand() {
        return command;
    }

    @Override
    public boolean isCommand(String command) {
        if (command.equalsIgnoreCase(this.commandName)) return true;
        return aliases.contains(command);
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public void toggle() {
        enabled = !enabled;
    }
}
