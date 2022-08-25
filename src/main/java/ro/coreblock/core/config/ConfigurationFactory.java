package ro.coreblock.core.config;

import ro.coreblock.api.config.ConfigurationApi;
import ro.coreblock.api.config.ConfigurationType;
import ro.coreblock.core.LoadingCore;

public class ConfigurationFactory {

    public ConfigurationApi<LoadingCore> getConfiguration(ConfigurationType configurationType) {
        if (configurationType.equals(ConfigurationType.AUTH)) {
            return new AuthConfiguration();
        } else if (configurationType.equals(ConfigurationType.PROTECTION)) {
            return new ProtectionConfiguration();
        }

        return null;
    }
}
