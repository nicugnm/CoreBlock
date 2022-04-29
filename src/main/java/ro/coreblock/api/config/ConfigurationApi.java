package ro.coreblock.api.config;

import ro.coreblock.LoadingCore;
import ro.coreblock.api.config.auth.ObjectConfiguration;

import java.util.List;

public interface ConfigurationApi {

    List<ObjectConfiguration> handleConfiguration(LoadingCore loadingCore);
}
