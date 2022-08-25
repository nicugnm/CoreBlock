package ro.coreblock.core.auth;

import lombok.AllArgsConstructor;
import lombok.Getter;
import ro.coreblock.api.auth.authentification.AuthentificationApi;
import ro.coreblock.core.auth.authentification.BedrockAuthentificationImpl;
import ro.coreblock.core.auth.authentification.bedrock.JavaAuthentificationImpl;

public class AuthentificationFactory {

    public AuthentificationApi getAuthentificationType(AuthentificationType authentificationType) {
        if (authentificationType == AuthentificationType.BEDROCK_PLAYER) {
            return new BedrockAuthentificationImpl();
        } else if (authentificationType == AuthentificationType.JAVA_PLAYER) {
            return new JavaAuthentificationImpl();
        }

        return null;
    }

    @AllArgsConstructor
    public enum AuthentificationType {
        BEDROCK_PLAYER("BEDROCK_PLAYER"),
        JAVA_PLAYER("JAVA_PLAYER");

        @Getter
        private final String name;
    }
}
