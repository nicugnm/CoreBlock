package ro.coreblock.implementation.chat;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.geysermc.floodgate.api.FloodgateApi;
import ro.coreblock.implementation.auth.authorization.PlayerAuthorizationImpl;

import static ro.coreblock.implementation.utils.UtilityCore.BEDROCK_FORMAT;
import static ro.coreblock.implementation.utils.UtilityCore.JAVA_FORMAT;

public class ChatHandlers implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        if (event.isAsynchronous()) {
            Player player = event.getPlayer();
            if (event.getMessage().equals("/login")) {
                PlayerAuthorizationImpl.authentificatedUsers.add(player.getUniqueId());
            }
            boolean isFloodgatePlayer = FloodgateApi.getInstance().isFloodgatePlayer(player.getUniqueId());
            String messageFormat;
            if (isFloodgatePlayer) {
                messageFormat = BEDROCK_FORMAT;
            } else {
                messageFormat = JAVA_FORMAT;
            }
            messageFormat = messageFormat.replace("%name", player.getName());
            messageFormat = messageFormat.replace("%message", event.getMessage());
            event.setFormat(messageFormat);
        }
    }
}
