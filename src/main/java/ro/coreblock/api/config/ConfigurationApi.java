package ro.coreblock.api.config;

import ro.coreblock.LoadingCore;

public interface ConfigurationApi {

    void createAuthConfiguration(LoadingCore loadingCore);

    void loadAuthConfiguration(LoadingCore loadingCore);

    void processConfigurationReplacements();
}
