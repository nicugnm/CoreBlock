package ro.coreblock.core;

import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import ro.coreblock.core.utils.UtilityCore;

import static ro.coreblock.core.utils.UtilityCore.PLUGIN_TAG;
import static ro.coreblock.core.utils.UtilityCore.INFO_ChatColor;

public class LoadingCore extends JavaPlugin {

    private final ConsoleCommandSender consoleCommandSender = this.getServer().getConsoleSender();

    @Override
    public void onDisable() {
        consoleCommandSender.sendMessage(PLUGIN_TAG + INFO_ChatColor + "has been disabled!");
    }

    @Override
    public void onLoad() {
        consoleCommandSender.sendMessage(PLUGIN_TAG + INFO_ChatColor + "has been loaded");
    }

    @Override
    public void onEnable() {
        // Enable message
        consoleCommandSender.sendMessage(PLUGIN_TAG + INFO_ChatColor + "has been enabled!");

        // Event Handlers
        consoleCommandSender.sendMessage(PLUGIN_TAG + INFO_ChatColor + "Registering handlers...");
        UtilityCore.registerEvents(this.getServer(), this);
        consoleCommandSender.sendMessage(PLUGIN_TAG + INFO_ChatColor + "Handlers has been registered!");

        consoleCommandSender.sendMessage(PLUGIN_TAG + INFO_ChatColor + "Registering Multilanguage files...");
        UtilityCore.registerMultilanguage(this);
        consoleCommandSender.sendMessage(PLUGIN_TAG + INFO_ChatColor + "Multilanguage files has been registered!");
    }
}
