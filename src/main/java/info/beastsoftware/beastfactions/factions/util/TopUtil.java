package info.beastsoftware.beastfactions.factions.util;

import info.beastsoftware.beastfactions.factions.entity.IFPlayer;
import info.beastsoftware.beastfactions.factions.entity.IFaction;
import info.beastsoftware.beastfactions.factions.entity.ITopCollSnapshot;
import info.beastsoftware.beastfactions.factions.entity.ITopEntityColl;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import utils.StrUtils;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TopUtil {




    public static void sendJsonEntry(IFPlayer ifPlayer,
                                     IFaction faction,
                                     String formatMessage,
                                     int pos,
                                     List<String> formatTooltip,
                                     long totalValue,
                                     long totalSpawnersValue,
                                     long totalBlocksValue,
                                     long totalPlayersMoney,
                                     HashMap<EntityType, Integer> spawnersValues,
                                     HashMap<Material, Integer> blocksValues){

        List<String> copy;
        String copyMessage;

        copyMessage = StrUtils.replacePlaceholder(formatMessage, "{position}", (pos + 1) + "");
        copyMessage = StrUtils.replacePlaceholder(copyMessage, "{faction_name}", faction.getName());
        copyMessage = StrUtils.replacePlaceholder(copyMessage, "{value}", totalValue + "");

        //create it with the format message
        JSONMessage jsonMessage = JSONMessage.create(StrUtils.translate(copyMessage));


        HashMap<String, String> placeholders = new HashMap<>();
        placeholders.put("top_position", faction.getTopPosition()+"");
        placeholders.put("faction_name", faction.getName());
        placeholders.put("spawners_total_value", totalSpawnersValue + "");
        placeholders.put("blocks_total_value", totalBlocksValue + "");
        placeholders.put("faction_owner_name", faction.getOwner().getName());
        placeholders.put("faction_total_value", totalValue + "");
        placeholders.put("faction_players_total_money", totalPlayersMoney + "");
        placeholders.put("richest_player_name", faction.getRichestPlayer().getName());

        for (EntityType entityType : spawnersValues.keySet()) {
            placeholders.put("amount_of_" + entityType.toString() + "_spawners", spawnersValues.get(entityType) + "");
        }


        for (Material material : blocksValues.keySet()) {
            placeholders.put("amount_of_" + material.toString() + "_blocks", blocksValues.get(material) + "");
        }

        //craft message and every line to the tooltip
        JSONMessage tooltip = JSONMessage.create();
        copy = StrUtils.craftMessageWithPlaceHolders(formatTooltip, placeholders);
        for (String line : copy) {
            tooltip.then(StrUtils.translate(line));
            tooltip.newline();
        }

        //send message
        jsonMessage.tooltip(tooltip);
        jsonMessage.send(ifPlayer.getPlayer());
    }



    public static void sendJsonEntryFromColl(ITopEntityColl coll, List<String> format, String formatMessage, IFPlayer player, IFaction faction, int pos){

        HashMap<Material, Integer> blocks = new HashMap<>();
        HashMap<EntityType, Integer> entityTypeIntegerHashMap = new HashMap<>();

        for(Material material : Material.values()){
            blocks.put(material, coll.getAllBlocksOfMaterial(material).size());
        }

        for (EntityType entityType : EntityType.values()) {
            if (!entityType.isAlive()) continue;
            entityTypeIntegerHashMap.put(entityType, coll.getNumberOfSpawnersOfType(entityType));
        }


        sendJsonEntry(player, faction, formatMessage, pos, format, coll.getTotalValue(), coll.getSpawnersTotalValue(), coll.getBlocksTotalValue(), faction.getAllPlayersMoney(), entityTypeIntegerHashMap, blocks);
    }


    public static void sendJsonEntryFromSnapshot(ITopCollSnapshot snapshot, List<String> format, String formatMessage, IFPlayer player, IFaction faction){

        HashMap<Material, Integer> blocks = new HashMap<>();
        HashMap<EntityType, Integer> entityTypeIntegerHashMap = new HashMap<>();

        for(Material material : Material.values()){
            blocks.put(material, snapshot.getAllBlocksOfMaterial(material));
        }

        for (EntityType entityType : EntityType.values()) {
            if (!entityType.isAlive()) continue;
            entityTypeIntegerHashMap.put(entityType, snapshot.getNumberOfSpawnersOfType(entityType));
        }

        sendJsonEntry(player, faction, formatMessage, 0, format, snapshot.getTotalValue(), snapshot.getSpawnersValue(), snapshot.getBlocksValue(), snapshot.getPlayersMoneyValue(), entityTypeIntegerHashMap, blocks);
    }



    public static void sendPageJsonMessage(int from, int to, HashMap<IFaction, ITopEntityColl> top,
                                           String header, List<String> formatTooltip, String formatMessage, IFPlayer ifPlayer) {

        ifPlayer.sms(" ");
        ifPlayer.sms(header);
        ifPlayer.sms(" ");
        int start = from;
        if (top == null || top.isEmpty()) return;
        for (Map.Entry<IFaction, ITopEntityColl> entry : top.entrySet()) {

            IFaction faction = entry.getKey();
            ITopEntityColl coll = entry.getValue();
            sendJsonEntryFromColl(coll,formatTooltip,formatMessage,ifPlayer,faction,start);
            start++;
        }


        ifPlayer.sms(" ");
    }


    public static LinkedHashMap<IFaction, ITopEntityColl> sortMap(HashMap<IFaction, ITopEntityColl> unsorted) {

//        //convert map to a List
//        List<Map.Entry<IFaction, ITopEntityColl>> list = new ArrayList<>(unsorted.entrySet());
//
//        //sorting the list with a comparator
//        list.sort(new SortByValue());
//
//        //convert sortedMap back to Map **** MUST BE LINKED HASHMAP ****
//        LinkedHashMap<IFaction, ITopEntityColl> sortedMap = new LinkedHashMap<>();
//        for (Map.Entry<IFaction, ITopEntityColl> entry : list) {
//            sortedMap.put(entry.getKey(), entry.getValue());
//        }


        return unsorted.values().parallelStream()
                .sorted((f1, f2) -> Long.compare(f2.getTotalValue(), f1.getTotalValue()))
                .collect(Collectors.toMap(
                        ITopEntityColl::getFaction,
                        Function.identity(),
                        (val1, val2) -> val1,
                        LinkedHashMap::new
                ));
    }


}
