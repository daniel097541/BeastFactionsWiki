package info.beastsoftware.beastfactions.config.manager;

import info.beastsoftware.beastfactions.struct.DataConfigType;
import config.IDataConfig;

public interface IDataConfigManager {
    IDataConfig getDataConfig(DataConfigType dataConfigType);

    void reload();
}
