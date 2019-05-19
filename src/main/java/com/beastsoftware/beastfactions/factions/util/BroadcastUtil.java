package com.beastsoftware.beastfactions.factions.util;

import com.beastsoftware.beastfactions.factions.entity.IFPlayer;
import com.beastsoftware.beastfactions.factions.entity.IFaction;

import java.util.List;

public class BroadcastUtil {


    public static void broadcastToFactionMembersExcept(IFaction faction, IFPlayer exception, String message) {

        for (IFPlayer player : faction.getOnlineFPlayers()) {

            if (exception != null && exception.equals(player)) continue;

            player.sms(message);

        }

    }

    public static void broadcastToFactionMembersExcept(List<IFPlayer> players, IFPlayer exception, String message) {

        for (IFPlayer player : players) {

            if (exception.equals(player)) continue;

            player.sms(message);

        }

    }

}
