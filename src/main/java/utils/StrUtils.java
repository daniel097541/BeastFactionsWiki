package utils;

import com.beastsoftware.beastfactions.factions.entity.IFPlayer;
import com.beastsoftware.beastfactions.factions.util.JSONMessage;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StrUtils {


    public static void sms(Player player, String message) {
        player.sendMessage(translate(message));
    }

    public static void sms(CommandSender player, String message) {
        player.sendMessage(translate(message));
    }

    public static String translate(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }

    public static List<String> translateLore(List<String> lore) {
        List<String> newLore = new ArrayList<>();
        for (String line : lore)
            newLore.add(translate(line));
        return newLore;
    }

    public static void mms(List<String> messages, Player player) {
        for (String message : messages)
            sms(player, message);
    }


    public static void mms(List<String> messages, CommandSender player) {
        for (String message : messages)
            sms(player, message);
    }

    public static String replacePlaceholder(String message, String placeholder, String replacement) {
        if (message.contains(placeholder))
            message = message.replace(placeholder, replacement);
        return message;
    }


    public static List<String> replacePlaceholder(List<String> lore, String placeholder, String replacement) {
        List<String> newLore = new ArrayList<>();
        for (String line : lore)
            newLore.add(replacePlaceholder(line, placeholder, replacement));
        return newLore;
    }


    public static String craftMessageWithPlaceHolders(String message, HashMap<String, String> placeholders) {

        for (Map.Entry<String, String> entry : placeholders.entrySet()) {
            message = replacePlaceholder(message, "{" + entry.getKey() + "}", entry.getValue());
        }

        return message;
    }

    public static List<String> craftMessageWithPlaceHolders(List<String> message, HashMap<String, String> placeholders) {

        List<String> replaced = new ArrayList<>();

        for (String msg : message) {
            replaced.add(craftMessageWithPlaceHolders(msg, placeholders));
        }

        return replaced;
    }

    public static String toString(Location location) {
        int x = location.getBlockX();
        int y = location.getBlockY();
        int z = location.getBlockZ();
        String world = location.getWorld().getName();

        return "&eWorld: &7" +
                world +
                ", " +
                "&eX: &7" +
                x +
                ", &eY: &7" +
                y +
                ", &eZ: &7" +
                z;
    }

    public static void sendJson(String message, String tooltip, String command, List<IFPlayer> players) {
        for (IFPlayer ifPlayer : players)
            sendJson(message, tooltip, command, ifPlayer);
    }

    public static void sendJson(String message, String tooltip, String command, IFPlayer player) {
        if (player == null) return;
        player.sms(" ");
        JSONMessage.create(translate(message))
                .runCommand(command)
                .tooltip(translate(tooltip))
                .send(player.getPlayer());
        player.sms(" ");
    }


    public static void sendTitle(String title, int fadeIn, int stay, int fadeOut, Player player) {
        JSONMessage.create(translate(title))
                .title(fadeIn, stay, fadeOut, player);
    }



}
