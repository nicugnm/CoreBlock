package ro.coreblock.implementation.auth.handlers;

import io.papermc.paper.event.player.PlayerItemFrameChangeEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import ro.coreblock.api.config.LanguageType;
import ro.coreblock.implementation.auth.authorization.PlayerAuthorizationImpl;
import ro.coreblock.implementation.config.utils.UtilityConfiguration;

import static ro.coreblock.implementation.utils.UtilityCore.PREFIX_MESSAGE;

public class AuthHandlers implements Listener {

    @EventHandler
    public void onMove(PlayerMoveEvent event) {
        PlayerAuthorizationImpl authorization = new PlayerAuthorizationImpl();
        Player player = event.getPlayer();
        if (!authorization.isAuthentificated(player)) {
            String authMessage = PREFIX_MESSAGE;
            var message = getMessageFromConfiguration(LanguageType.EN, "player.move");

            authMessage = authMessage.replace("%message", message);
            player.sendMessage(authMessage);
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        PlayerAuthorizationImpl authorization = new PlayerAuthorizationImpl();
        Player player = event.getPlayer();
        if (!authorization.isAuthentificated(player)) {
            String authMessage = PREFIX_MESSAGE;
            var message = getMessageFromConfiguration(LanguageType.EN, "player.block_break");

            authMessage = authMessage.replace("%message", message);
            player.sendMessage(authMessage);
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onItemFrame(PlayerItemFrameChangeEvent event) {
        PlayerAuthorizationImpl authorization = new PlayerAuthorizationImpl();
        Player player = event.getPlayer();
        if (!authorization.isAuthentificated(player)) {
            String authMessage = PREFIX_MESSAGE;
            var message = getMessageFromConfiguration(LanguageType.EN, "player.item_frame");

            authMessage = authMessage.replace("%message", message);
            player.sendMessage(authMessage);
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onPlace(BlockPlaceEvent event) {
        PlayerAuthorizationImpl authorization = new PlayerAuthorizationImpl();
        Player player = event.getPlayer();
        if (!authorization.isAuthentificated(player)) {
            String authMessage = PREFIX_MESSAGE;
            var message = getMessageFromConfiguration(LanguageType.EN, "player.block_place");

            authMessage = authMessage.replace("%message", message);
            player.sendMessage(authMessage);
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        PlayerAuthorizationImpl authorization = new PlayerAuthorizationImpl();
        Player player = event.getPlayer();
        if (!authorization.isAuthentificated(player)) {
            String authMessage = PREFIX_MESSAGE;
            var message = getMessageFromConfiguration(LanguageType.EN, "player.interact");

            authMessage = authMessage.replace("%message", message);
            player.sendMessage(authMessage);
            event.setCancelled(true);
        }
    }
    
    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        PlayerAuthorizationImpl authorization = new PlayerAuthorizationImpl();
        Player player = event.getPlayer();
        if (!authorization.isAuthentificated(player)) {
            String authMessage = PREFIX_MESSAGE;
            var message = getMessageFromConfiguration(LanguageType.EN, "player.chat");

            authMessage = authMessage.replace("%message", message);
            player.sendMessage(authMessage);
            event.setCancelled(true);
        }
    }

    private String getMessageFromConfiguration(LanguageType languageType, String message) {
        return UtilityConfiguration.AUTH_CONFIGURATION.stream()
                .filter(objectConfiguration -> objectConfiguration.getLanguageType() == languageType)
                .findFirst()
                .get()
                .getLanguageSet().get(message);

    }
}
