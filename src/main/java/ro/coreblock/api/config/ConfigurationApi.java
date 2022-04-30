package ro.coreblock.api.config;

import ro.coreblock.LoadingCore;

import java.util.List;

public interface ConfigurationApi {

    List<ObjectConfiguration> handleConfiguration(LoadingCore loadingCore);
}
