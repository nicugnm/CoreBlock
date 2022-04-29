package ro.coreblock.implementation.config;

import lombok.SneakyThrows;
import ro.coreblock.LoadingCore;
import ro.coreblock.api.config.ConfigurationApi;
import ro.coreblock.api.config.auth.ObjectConfiguration;

import java.util.List;

import static ro.coreblock.implementation.utils.UtilityCore.PROTECTION_PATH;

public class ProtectionConfiguration extends AbstractConfiguration implements ConfigurationApi {

    @SneakyThrows
    @Override
    public List<ObjectConfiguration> handleConfiguration(LoadingCore loadingCore) {
        return super.createConfiguration(loadingCore, PROTECTION_PATH);
    }
}
