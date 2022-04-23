package ro.coreblock.api.config.auth;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ObjectConfiguration {

    private LanguageType languageType;

    private Map<String, String> languageSet;
}
