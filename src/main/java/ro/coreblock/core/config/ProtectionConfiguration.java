package ro.coreblock.core.config;

import lombok.SneakyThrows;
import ro.coreblock.api.config.ConfigurationApi;
import ro.coreblock.api.config.ObjectConfiguration;
import ro.coreblock.core.LoadingCore;

import java.util.List;

import static ro.coreblock.core.utils.UtilityCore.PROTECTION_PATH;

public class ProtectionConfiguration extends AbstractConfiguration implements ConfigurationApi<LoadingCore> {

    @SneakyThrows
    @Override
    public List<ObjectConfiguration> handleConfiguration(LoadingCore loadingCore) {
        return super.createConfiguration(loadingCore, PROTECTION_PATH);
    }
}
