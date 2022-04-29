package ro.coreblock.api.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public enum ConfigurationType {
    AUTH("AUTH"),
    PROTECTION("PROTECTION");

    private final String name;
}
