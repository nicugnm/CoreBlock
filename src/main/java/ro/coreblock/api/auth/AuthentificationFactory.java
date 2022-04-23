package ro.coreblock.api.auth;

import ro.coreblock.api.auth.authentification.AuthentificationApi;
import ro.coreblock.implementation.auth.authentification.BedrockAuthentificationImpl;
import ro.coreblock.implementation.auth.authentification.bedrock.JavaAuthentificationImpl;

public interface AuthentificationFactory {

    default AuthentificationApi getAuthentificationType(AuthentificationType authentificationType) {
        switch (authentificationType) {
            case BEDROCK_PLAYER -> new BedrockAuthentificationImpl();
            case JAVA_PLAYER -> new JavaAuthentificationImpl();
        }
        return null;
    }

    enum AuthentificationType {
        BEDROCK_PLAYER,
        JAVA_PLAYER
    }
}
