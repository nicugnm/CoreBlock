package ro.coreblock.api.auth.authorization;

import org.bukkit.entity.Player;

public interface AuthorizationApi {
    boolean isAuthentificated(Player player);
}
