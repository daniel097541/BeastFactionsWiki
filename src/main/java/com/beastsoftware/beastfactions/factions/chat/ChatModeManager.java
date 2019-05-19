package com.beastsoftware.beastfactions.factions.chat;

import com.beastsoftware.beastfactions.factions.entity.IChatMode;
import com.beastsoftware.beastfactions.factions.entity.IRelation;
import com.beastsoftware.beastfactions.factions.entity.impl.ChatMode;
import com.beastsoftware.beastfactions.injection.annotations.MainConfiguration;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import config.IConfig;
import org.bukkit.configuration.file.YamlConfiguration;

@Singleton
public class ChatModeManager implements IChatModeManager {


    @Inject
    @MainConfiguration
    private IConfig mainConfig;


    @Override
    public IChatMode getChatModeOfRelation(IRelation relation) {

        String path = "Configuration.Factions.Relations.default-faction-relations." + relation.getName() + ".Chat-Mode-Settings.";

        if (!relationHasChatMode(relation))
            return null;

        YamlConfiguration configuration = mainConfig.getConfig();

        String prefix = configuration.getString(path + "prefix");
        String sufix = configuration.getString(path + "sufix");
        String format = configuration.getString(path + "format-crafted");

        return new ChatMode(relation, format, prefix, sufix);
    }

    @Override
    public boolean relationHasChatMode(IRelation relation) {
        YamlConfiguration configuration = mainConfig.getConfig();
        return configuration.getBoolean("Configuration.Factions.Relations.default-faction-relations." + relation.getName() + ".has-chat-channel");
    }
}
