package ro.coreblock.implementation.config.utils;

import lombok.experimental.UtilityClass;
import ro.coreblock.api.config.auth.ObjectConfiguration;

import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class UtilityConfiguration {

    public static List<ObjectConfiguration> AUTH_CONFIGURATION = new ArrayList<>();
    public static List<ObjectConfiguration> PROTECTION_CONFIGURATION = new ArrayList<>();


}
