package ro.coreblock.core.utils;

import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import ro.coreblock.core.LoadingCore;
import ro.coreblock.api.config.ConfigurationType;
import ro.coreblock.core.auth.handlers.AuthHandlers;
import ro.coreblock.core.chat.ChatHandlers;
import ro.coreblock.core.config.ConfigurationFactory;
import ro.coreblock.core.config.utils.UtilityConfiguration;
import ro.coreblock.core.protection.handlers.ProtectionHandlers;

@UtilityClass
public class UtilityCore {

    public static final String AUTH_PATH = "language/auth";
    public static final String PROTECTION_PATH = "language/protection";

    private static final String SPACE = " ";
    private static final String CHAT_PREFIX_BEFORE_MESSAGE = ChatColor.YELLOW + "»";

    public static final ChatColor INFO_ChatColor = ChatColor.GRAY;

    public static final String TITLE = ChatColor.BOLD.toString() + ChatColor.DARK_RED + "!" + " " + ChatColor.RESET + ChatColor.RED + "%titleMessage";
    public static final String SUBTITLE = ChatColor.GRAY + "%subtitleMessage";

    public static final String PLUGIN_TAG = ChatColor.GREEN + "[" + ChatColor.YELLOW + "CoreBlock" + ChatColor.GREEN + "]" + SPACE;

    public static final String BEDROCK_FORMAT = ChatColor.BLACK + "[" + ChatColor.RED + "BE" + ChatColor.BLACK + "]" + SPACE + ChatColor.GRAY+ "%name" + SPACE + CHAT_PREFIX_BEFORE_MESSAGE + SPACE + ChatColor.GRAY + "%message";
    public static final String JAVA_FORMAT = ChatColor.BLACK + "[" + ChatColor.RED + "PC" + ChatColor.BLACK + "]" + SPACE + ChatColor.GRAY + "%name" + SPACE + CHAT_PREFIX_BEFORE_MESSAGE + SPACE + ChatColor.GRAY + "%message";

    public static final String PREFIX_MESSAGE = ChatColor.RED.toString() + ChatColor.BOLD + "!" + ChatColor.RESET + SPACE + ChatColor.GRAY + "%message";

    public void registerEvents(Server server, LoadingCore main) {
        server.getPluginManager().registerEvents(new ChatHandlers(), main);
        server.getPluginManager().registerEvents(new AuthHandlers(), main);
        server.getPluginManager().registerEvents(new ProtectionHandlers(), main);
    }

    @SneakyThrows
    public static void registerMultilanguage(LoadingCore main) {
        ConfigurationFactory configurationFactory = new ConfigurationFactory();
        var authConfiguration = configurationFactory.getConfiguration(ConfigurationType.AUTH)
                .handleConfiguration(main);
        var protectionConfiguration = configurationFactory.getConfiguration(ConfigurationType.PROTECTION)
                .handleConfiguration(main);

        UtilityConfiguration.AUTH_CONFIGURATION = authConfiguration;
        UtilityConfiguration.PROTECTION_CONFIGURATION = protectionConfiguration;
    }
}
