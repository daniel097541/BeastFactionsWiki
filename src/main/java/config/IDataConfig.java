package config;

import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.util.HashMap;
import java.util.List;

public interface IDataConfig {
    void createConfig(File file, YamlConfiguration config);

    YamlConfiguration getConfigByName(String name);

    void save(String name);

    void loadConfig(String name);

    void reload();

    HashMap<String, YamlConfiguration> getConfigs();

    String getFolder();

    List<File> getAllFilesInFolder();

    boolean isConfigInFolder(String name);

    void remove(String name);

    boolean exists(String name);

    void loadAll();


}
