package ro.coreblock.implementation.protection;

import ro.coreblock.api.protection.ProtectionApi;
import ro.coreblock.implementation.protection.attack.AttackOnProtection;

public class ProtectionFactory {

    public ProtectionApi getProtectionType(ProtectionType protectionType) {
        return new AttackOnProtection();
    }

    public enum ProtectionType {
        LAVA_WATER
    }
}
