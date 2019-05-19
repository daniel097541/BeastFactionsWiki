package com.beastsoftware.beastfactions.config.dataconfig;

import config.BeastDataConfig;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class FactionsDataConfiguration extends BeastDataConfig {
    public FactionsDataConfiguration(String folder) {
        super(folder);
        loadAll();
    }

    @Override
    public void createConfig(File file, YamlConfiguration config) {

    }

    @Override
    public void loadAll() {
        if (getAllFilesInFolder() == null) return;
        for (File file : getAllFilesInFolder()) {
            loadConfig(file.getName().replace(".yml", ""));
        }
    }
}
