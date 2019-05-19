package com.beastsoftware.beastfactions.factions.gui.struct;

public enum CommonButtonPath {

    BACK_BUTTON("GUIS.Common-Buttons.Back-Button."),
    CLOSE_BUTTON("GUIS.Common-Buttons.Close-Button."),
    PREVIOUS_BUTTON("GUIS.Common-Buttons.Previous-Page-Button."),
    NEXT_BUTTON("GUIS.Common-Buttons.Next-Page-Button."),
    HOME_BUTTON("GUIS.Common-Buttons.Home-Button.");

    private String path;


    CommonButtonPath(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
