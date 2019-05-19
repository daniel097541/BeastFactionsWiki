package com.beastsoftware.beastfactions.factions.struct;

public enum FCommandType {

    WORLDEDITCLAIM_COMMAND("weclaim", 1, false),
    TNTBANK_COMMAND("tntbank", 1, false),
    CLAIMAT_COMMAND("claimat", 3, true),
    MIGRATE_COMMAND("migrate", 1, false),
    WARN_COMMAND("warn", 2, true),
    MONEY_COMMAND("money", 1, false),
    CORNERS_COMMAND("corners", 1, false),
    MULTIUNCLAIM_COMMAND("multiunclaim", 1, false),
    UNCLAIMALL_COMMAND("unclaimall", 1, false),
    MULTICLAIM_COMMAND("multiclaim", 1, false),
    AUTOCLAIM_COMMAND("autoclaim", 1, true),
    SEECHUNK_COMMAND("seechunk", 1, false),
    RENAME_COMMAND("rename", 2, true),
    NEAR_COMMAND("near", 1, true),
    POWERBOOST_COMMAND("powerboost", 1, false),
    BYPASS_COMMAND("bypass", 1, false),
    MAP_COMMAND("map", 1, false),
    CHAT_COMMAND("chat", 2, true),
    TOP_COMMAND("top", 1, false),
    RELATION_COMMAND("relation", 2, false),
    TAG_COMMAND("tag", 2, true),
    WARP_COMMAND("warp", 1, false),
    PERMISSION_COMMAND("permission", 1, false),
    ROLES_COMMAND("role", 1, false),
    LIST_COMMAND("list", 2, false),
    HOME_COMMAND("home", 1, false),
    SETHOME_COMMAND("sethome", 1, true),
    FLY_COMMAND("fly", 1, false),
    ACCEPT_COMMAND("accept", 2, true),
    KICK_COMMAND("kick", 2, true),
    INVITE_COMMAND("invite", 2, true),
    UNCLAIM_COMMAND("unclaim", 1, false),
    CLAIM_COMMAND("claim", 1, false),
    SHOW_COMMAND("show", 1, false),
    POWER_COMMAND("power", 1, false),
    LISTPERMISSIONS_COMMAND("listpermissions", 1, true),
    HELP_COMMAND("help", 2, false),
    DISBAND_COMMAND("disband", 1, false),
    LEAVE_COMMAND("leave", 1, true),
    CREATE_COMMAND("create", 2, true),
    RELOAD_COMMAND("reload", 1, true);


    private String commandName;
    private int requiredArgs;
    private boolean checkArgs;

    FCommandType(String commandName, int requiredArgs, boolean checkArgs) {
        this.commandName = commandName;
        this.requiredArgs = requiredArgs;
        this.checkArgs = checkArgs;
    }


    public String getCommandName() {
        return commandName;
    }


    public int getRequiredArgs() {
        return requiredArgs;
    }

    public boolean checkArgs() {
        return checkArgs;
    }
}
