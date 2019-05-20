package info.beastsoftware.beastfactions.factions.defaultFactions;

import info.beastsoftware.beastfactions.factions.entity.IDefaultFaction;
import info.beastsoftware.beastfactions.factions.entity.impl.DefaultFaction;
import info.beastsoftware.beastfactions.injection.annotations.MainConfiguration;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import config.IConfig;
import gnu.trove.map.TLongIntMap;
import gnu.trove.map.TLongObjectMap;
import gnu.trove.map.hash.TLongIntHashMap;
import gnu.trove.map.hash.TLongObjectHashMap;
import org.bukkit.configuration.file.YamlConfiguration;

import java.util.ArrayList;
import java.util.List;


@Singleton
public class DefaultFactionsManager implements IDefaultFactionsManager {


    @Inject
    @MainConfiguration
    private IConfig mainConfig;

    private TLongIntMap factionlessCache = new TLongIntHashMap();
    private TLongIntMap allowsPvPCache = new TLongIntHashMap();
    private TLongIntMap getAllowsFightCache = new TLongIntHashMap();
    private TLongIntMap powerLostCache = new TLongIntHashMap();
    private TLongObjectMap colorCache = new TLongObjectHashMap();




    @Override
    public List<IDefaultFaction> getDefaultFactions() {

        List<IDefaultFaction> defaultFactions = new ArrayList<>();

        YamlConfiguration configuration = mainConfig.getConfig();

        String path = "Configuration.Factions.Default-Factions";

        long id = 0L;
        for (String section : configuration.getConfigurationSection(path).getKeys(false)) {
            String path2 = path + "." + section + ".";
            String name = configuration.getString(path2 + "name");
            IDefaultFaction faction = new DefaultFaction(name, id);
            defaultFactions.add(faction);
            id--;
        }

        return defaultFactions;
    }

    @Override
    public boolean allowsPvP(IDefaultFaction faction) {

        if (allowsPvPCache.containsKey(faction.getId())) return allowsPvPCache.get(faction.getId()) == 0;

        YamlConfiguration configuration = mainConfig.getConfig();
        String path = "Configuration.Factions.Default-Factions." + faction.getName() + ".block-pvp";
        boolean allowsPvP = !configuration.getBoolean(path);
        if (allowsPvP) allowsPvPCache.put(faction.getId(), 0);
        else allowsPvPCache.put(faction.getId(), 1);
        return allowsPvP;
    }

    @Override
    public boolean allowsCommand(IDefaultFaction faction, String command) {
        YamlConfiguration configuration = mainConfig.getConfig();
        String path = "Configuration.Factions.Default-Factions." + faction.getName() + ".";
        List<String> commands;


        boolean blackList = configuration.getBoolean(path + "command-blacklist-mode");

        //// blacklist mode, look for blocked commands
        if (blackList) {
            commands = configuration.getStringList(path + "command-blacklist");
            for (String blocked : commands) {
                //command is blocked
                if (blocked.toLowerCase().startsWith(command.toLowerCase()) || command.toLowerCase().startsWith(blocked.toLowerCase()))
                    return false;
            }

            //command is not blocked
            return true;
        }

        boolean whitelist = configuration.getBoolean(path + "command-whitelist-mode");

        if (whitelist) {

            commands = configuration.getStringList(path + "command-whitelist");

            for (String allowed : commands) {

                //command allowed
                if (allowed.toLowerCase().startsWith(command.toLowerCase()))
                    return true;
            }

            //command not allowed
            return false;
        }


        //i dont know so always true
        return true;
    }

    @Override
    public boolean allowsFlight(IDefaultFaction faction) {
        long id = faction.getId();
        if (getAllowsFightCache.containsKey(id)) return getAllowsFightCache.get(id) == 0;

        YamlConfiguration configuration = mainConfig.getConfig();
        String path = "Configuration.Factions.Default-Factions." + faction.getName() + ".allow-flight";
        boolean allowsFlight = configuration.getBoolean(path);
        if (allowsFlight) getAllowsFightCache.put(id, 0);
        else getAllowsFightCache.put(id, 1);
        return allowsFlight;
    }

    @Override
    public String getColor(IDefaultFaction faction) {
        long id = faction.getId();
        if (colorCache.containsKey(id))
            return (String) colorCache.get(id);

        YamlConfiguration configuration = mainConfig.getConfig();
        String path = "Configuration.Factions.Default-Factions." + faction.getName() + ".color";
        return configuration.getString(path);
    }

    @Override
    public boolean isFactionless(IDefaultFaction faction) {

        long id = faction.getId();
        if (factionlessCache.containsKey(id))
            return factionlessCache.get(id) == 0;

        YamlConfiguration configuration = mainConfig.getConfig();
        String path = "Configuration.Factions.Default-Factions." + faction.getName() + ".is-factionless";
        boolean factionLess = configuration.getBoolean(path);

        if (factionLess)
            factionlessCache.put(id, 0);
        else factionlessCache.put(id, 1);
        return factionLess;
    }

    @Override
    public boolean powerLostAtDeath(IDefaultFaction faction) {

        long id = faction.getId();

        if (powerLostCache.containsKey(id)) {
            return powerLostCache.get(id) == 0;
        }

        YamlConfiguration configuration = mainConfig.getConfig();
        String path = "Configuration.Factions.Default-Factions." + faction.getName() + ".power-lost-at-death";
        boolean powerLost = configuration.getBoolean(path);

        if (powerLost)
            powerLostCache.put(id, 0);
        else powerLostCache.put(id, 1);

        return powerLost;
    }


}
