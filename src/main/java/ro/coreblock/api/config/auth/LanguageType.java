package ro.coreblock.api.config.auth;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public enum LanguageType {
    RO("RO"),
    EN("EN");

    private final String name;
}
