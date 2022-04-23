package ro.coreblock.api.config;

import ro.coreblock.implementation.config.AuthConfiguration;

public class ConfigurationFactory {

    public ConfigurationApi getConfiguration(ConfigurationType configurationType) {
        return new AuthConfiguration();
    }

    public enum ConfigurationType {
        AUTH
    }
}
