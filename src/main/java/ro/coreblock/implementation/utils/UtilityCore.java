package ro.coreblock.implementation.utils;

import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import ro.coreblock.LoadingCore;
import ro.coreblock.api.config.ConfigurationFactory;
import ro.coreblock.implementation.auth.handlers.AuthHandlers;
import ro.coreblock.implementation.chat.ChatHandlers;

@UtilityClass
public class UtilityCore {

    public static final String AUTH_PATH = "language/auth";

    private static final String SPACE = " ";
    private static final String CHAT_PREFIX_BEFORE_MESSAGE = ChatColor.YELLOW + "»";

    public static final ChatColor INFO_ChatColor = ChatColor.GRAY;

    public static final String PLUGIN_TAG = ChatColor.GREEN + "[" + ChatColor.YELLOW + "CoreBlock" + ChatColor.GREEN + "]" + SPACE;

    public static final String BEDROCK_FORMAT = ChatColor.BLACK + "[" + ChatColor.RED + "BE" + ChatColor.BLACK + "]" + SPACE + ChatColor.GRAY+ "%name" + SPACE + CHAT_PREFIX_BEFORE_MESSAGE + SPACE + ChatColor.GRAY + "%message";
    public static final String JAVA_FORMAT = ChatColor.BLACK + "[" + ChatColor.RED + "PC" + ChatColor.BLACK + "]" + SPACE + ChatColor.GRAY + "%name" + SPACE + CHAT_PREFIX_BEFORE_MESSAGE + SPACE + ChatColor.GRAY + "%message";

    public static final String NOT_AUTHENTIFICATED_PLAYER_MESSAGE = ChatColor.RED.toString() + ChatColor.BOLD + "!" + ChatColor.RESET + SPACE + ChatColor.GRAY + "%message";

    public void registerEvents(Server server, LoadingCore main) {
        server.getPluginManager().registerEvents(new ChatHandlers(), main);
        server.getPluginManager().registerEvents(new AuthHandlers(), main);
    }

    @SneakyThrows
    public void registerMultilanguage(LoadingCore main) {
        ConfigurationFactory configurationFactory = new ConfigurationFactory();
        configurationFactory.getConfiguration(ConfigurationFactory.ConfigurationType.AUTH)
                .createAuthConfiguration(main);
    }
}
