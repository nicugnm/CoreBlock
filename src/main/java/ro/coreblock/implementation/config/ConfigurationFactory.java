package ro.coreblock.implementation.config;

import ro.coreblock.api.config.ConfigurationApi;
import ro.coreblock.api.config.ConfigurationType;

public class ConfigurationFactory {

    public ConfigurationApi getConfiguration(ConfigurationType configurationType) {
        if (configurationType.equals(ConfigurationType.AUTH)) {
            return new AuthConfiguration();
        } else if (configurationType.equals(ConfigurationType.PROTECTION)) {
            return new ProtectionConfiguration();
        }

        return null;
    }
}
