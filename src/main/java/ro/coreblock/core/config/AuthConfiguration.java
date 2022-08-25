package ro.coreblock.core.config;

import lombok.SneakyThrows;
import ro.coreblock.api.config.ConfigurationApi;
import ro.coreblock.api.config.ObjectConfiguration;
import ro.coreblock.core.LoadingCore;

import java.util.List;

import static ro.coreblock.core.utils.UtilityCore.AUTH_PATH;

public class AuthConfiguration extends AbstractConfiguration implements ConfigurationApi<LoadingCore> {

    @SneakyThrows
    @Override
    public List<ObjectConfiguration> handleConfiguration(LoadingCore loadingCore) {
        return super.createConfiguration(loadingCore, AUTH_PATH);
    }
}
