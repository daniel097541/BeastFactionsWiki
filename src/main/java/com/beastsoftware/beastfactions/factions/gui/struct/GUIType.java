package com.beastsoftware.beastfactions.factions.gui.struct;

public enum GUIType {

    TOP_GUI("GUIS.Top-GUI."),
    WARPS_GUI("GUIS.Warps-GUI."),
    RELATIONS_PERMISSIONS_MANAGE_GUI("GUIS.Permissions-GUI.Relation-Permissions-Manage-GUI."),
    RELATIONS_PERMISSIONS_PAGE("GUIS.Permissions-GUI.Relations-Permissions-GUI."),
    MAIN_PERMISSIONS_PAGE("GUIS.Permissions-GUI.Main-Permissions-GUI."),
    ROLES_PERMISSIONS_PAGE("GUIS.Permissions-GUI.Roles-Permissions-GUI."),
    PLAYERS_LIST_PAGE("GUIS.Permissions-GUI.Players-Permissions-GUI."),
    PLAYER_PERMISSIONS_MANAGE_GUI("GUIS.Permissions-GUI.Player-Permissions-Manage-GUI."),
    ROLE_PERMISSIONS_MANAGE_GUI("GUIS.Permissions-GUI.Role-Permissions-Manage-GUI.");


    private String path;

    GUIType(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
