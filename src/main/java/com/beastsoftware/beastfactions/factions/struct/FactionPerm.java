package com.beastsoftware.beastfactions.factions.struct;

public enum FactionPerm {


    TNTBANK("&eAllos players to use tntbank command!", false),
    BREAK_BLOCKS("&eAllows players to break blocks in your land!", true),
    BUILD("&eAllows players to build in your land!", true),
    MULTIUNCLAIM("&eAllows players to multiunclaim land from your faction!", false),
    MULTICLAIM("&eAllows players to multiclaim land for your faction!", false),
    CHANGEROLEPREFIX("&eAllows players to change the role prefixes of your faction roles!", false),
    SETROLE("&eAllows players to change other players role!", false),
    MANAGEPERMISSIONS("&eAllows players to manage permissions in your faction!", false),
    CREATEROLE("&eAllows players to create new roles for your faction!", false),
    HOME("&eAllows players to use the command: &7/f home", false),
    SETHOME("&eAllows players to use the command: &7/f sethome", false),
    FLY("&eAllows your players to fly inside your faction!", true),
    KICK("&eAllows players to kick other players from your faction!", false),
    INVITE("&eAllows players to invite other players to your faction!", false),
    AUTOCLAIM("&eAllows players to use the command: &7/f autoclaim &7( &6needs the CLAIM permission &7)", false),
    CLAIM("&eAllows players to claim land for your faction!", false),
    UNCLAIM("&eAllows players to unclaim land for your faction! &4WARNING", false),
    UNCLAIMALL("&eAllows players to unclaim all the land of your faction! &4WARNING", false),
    ALL("&eAllows players to do anything they want! &4WARNING", false),
    USEWARPS("&eAllows players to use the command: &7/f warp!", false),
    CREATEWARPS("&eAllows players to create new warps!", false),
    DELETEWARPS("&eAllows players to delete warps!", false),
    UPDATEWARPS("&eAllows players to update the location of existing warps!", false),
    DISBAND("&eAllows players to disband your faction! &4WARNING", false),
    CHANGE_TAG("&eAllows players to change the name of your faction!", false),
    MANAGE_RELATIONS("&eAllows players to manage relations with other factions!", false),
    NEAR_COMMAND("&eAllows players to use the command: &7/f near", true),
    RENAME("&eAllows players to change the name of your faction!", false),
    SEE_TOP_PROGRESS("&eAllows players to see the progress of your faction in top!", false),
    WITHDRAW_MONEY("&eAllows players to withdraw money from your factions bank! &4WARNING", false),
    DEPOSIT_MONEY("&eAllows players to deposit money in your factions bank!", false);


    private String desc;
    private boolean relationpermissable;

    FactionPerm(String desc, boolean relationpermissable) {
        this.desc = desc;
        this.relationpermissable = relationpermissable;
    }

    public boolean isRelationpermissable() {
        return relationpermissable;
    }

    public String getDesc() {
        return desc;
    }
}
