package info.beastsoftware.beastfactions.factions.placeholder;

import info.beastsoftware.beastfactions.factions.entity.IFPlayer;
import info.beastsoftware.beastfactions.factions.entity.IFaction;
import info.beastsoftware.beastfactions.factions.util.JSONMessage;
import utils.StrUtils;

import java.util.ArrayList;
import java.util.List;

public class FactionsPlaceholdersUtil {


    public static String formatMessageWithFacName(String message, IFaction faction, IFPlayer receiver) {

        if (message.contains("{faction_name}"))
            message = message.replace("{faction_name}", faction.getName());

        if (message.contains("{faction_name_color_formatted}"))
            message = message.replace("{faction_name_color_formatted}", faction.getNameColorFormattedWithFaction(receiver.getFaction()));

        return message;
    }


    public static List<String> formatLoreForFaction(List<String> lore, IFaction faction, IFPlayer player) {
        List<String> returned = new ArrayList<>();
        for (String message : lore) {
            if (message.contains("{faction_name}"))
                message = message.replace("{faction_name}", faction.getName());

            if (message.contains("{faction_name_color_formatted}"))
                message = message.replace("{faction_name_color_formatted}", faction.getNameColorFormattedWithFaction(player.getFaction()));

            if (message.contains("{pos_in_top}"))
                message = message.replace("{pos_in_top}", faction.getTopPosition() + "");

            if (message.contains("{owner_name}"))
                message = message.replace("{owner_name}", faction.getOwner().getName());

            if (message.contains("{online_players}"))
                message = message.replace("{online_players}", faction.getOnlineFPlayers().size() + "");

            if (message.contains("{claims_power_message}")) {
                String color = "&a";
                if (faction.getPower() < faction.getAmountOfClaims())
                    color = "&c";
                message = message.replace("{claims_power_message}", color + faction.getAmountOfClaims() + " / " + faction.getPower());
            }

            returned.add(StrUtils.translate(message));
        }
        return returned;
    }


    public static JSONMessage formatLoreForFactionToJson(List<String> lore, IFPlayer player, IFaction faction) {
        JSONMessage jsonMessage = JSONMessage.create();


        for (String line : formatLoreForFaction(lore, faction, player)) {

            jsonMessage = jsonMessage.then(line);
            jsonMessage = jsonMessage.newline();
        }

        return jsonMessage;
    }


}
