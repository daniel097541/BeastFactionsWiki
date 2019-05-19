package config;

import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public abstract class BeastDataConfig implements IDataConfig {

    private HashMap<String, YamlConfiguration> configs;
    private HashMap<String, File> files;
    private String folder;

    public BeastDataConfig(String folder) {
        this.folder = folder;
        configs = new HashMap<>();
        files = new HashMap<>();
    }


    @Override
    public void loadConfig(String name) {
        File file = new File(folder, name + ".yml");
        YamlConfiguration config = YamlConfiguration.loadConfiguration(file);
        if (!file.exists())
            createConfig(file, config);
        configs.put(name, config);
        files.put(name, file);
    }

    @Override
    public void save(String name) {
        try {
            configs.get(name).save(files.get(name));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void reload() {
        configs = new HashMap<>();
        files = new HashMap<>();
    }

    @Override
    public YamlConfiguration getConfigByName(String name) {
        if (configs.keySet().contains(name) && isConfigInFolder(name))
            loadConfig(name);
        return configs.get(name);
    }


    @Override
    public HashMap<String, YamlConfiguration> getConfigs() {
        return configs;
    }

    @Override
    public String getFolder() {
        return folder;
    }

    @Override
    public List<File> getAllFilesInFolder() {
        File folder = new File(getFolder());
        File[] files = folder.listFiles();
        if (files == null || files.length == 0) return new ArrayList<>();
        return Arrays.asList(files);
    }


    @Override
    public boolean isConfigInFolder(String name) {
        List<File> files = getAllFilesInFolder();
        if (files == null) return false;
        if (files.size() == 0) return false;
        for (File file : files)
            if (file.getName().replace(".yml", "").equalsIgnoreCase(name))
                return true;
        return false;
    }

    @Override
    public void remove(String name) {
        File file = files.get(name);
        if (file == null) return;
        if (!file.delete()) return;
        files.remove(name);
        configs.remove(name);
    }

    @Override
    public boolean exists(String name) {
        return configs.containsKey(name);
    }
}
