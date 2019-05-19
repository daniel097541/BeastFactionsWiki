package com.beastsoftware.beastfactions.config.manager;

import com.beastsoftware.beastfactions.struct.DataConfigType;
import config.IDataConfig;

public interface IDataConfigManager {
    IDataConfig getDataConfig(DataConfigType dataConfigType);

    void reload();
}
