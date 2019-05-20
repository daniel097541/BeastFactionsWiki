package info.beastsoftware.beastfactions.factions.entity;

import java.io.Serializable;
import java.util.List;

public interface IRelation extends Serializable {

    String getName();

    String getColour();

    List<String> getBlackListedCommands();

    List<String> getWhiteListedCommands();

    boolean isAllowTeleportInLand();

    boolean isOnBlackList();

    boolean isOnWhiteList();

    boolean isDefaultRelation();

    boolean isPvPAllowed();

    boolean isBlockPlaceAllowed();

    boolean isBlockBreakAllowed();

    String getNoPvPMessage();

    String getNoBreakMessage();

    String getNoPlaceMessage();

    String getNoCommandUseMessage();

    boolean requiresRequest();

    boolean hasChatMode();

    IChatMode getChatMode();

    boolean cancelsFlight();

    String getNameWithColor();

    boolean isOwnFactionRelation();
}
