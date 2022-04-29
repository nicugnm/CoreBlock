package ro.coreblock.implementation.auth;

import lombok.AllArgsConstructor;
import lombok.Getter;
import ro.coreblock.api.auth.authentification.AuthentificationApi;
import ro.coreblock.implementation.auth.authentification.BedrockAuthentificationImpl;
import ro.coreblock.implementation.auth.authentification.bedrock.JavaAuthentificationImpl;

public class AuthentificationFactory {

    public AuthentificationApi getAuthentificationType(AuthentificationType authentificationType) {
        switch (authentificationType) {
            case BEDROCK_PLAYER -> new BedrockAuthentificationImpl();
            case JAVA_PLAYER -> new JavaAuthentificationImpl();
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
