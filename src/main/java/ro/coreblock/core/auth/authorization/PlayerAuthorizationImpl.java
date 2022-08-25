package ro.coreblock.core.auth.authorization;

import org.bukkit.entity.Player;
import ro.coreblock.api.auth.authorization.AuthorizationApi;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class PlayerAuthorizationImpl implements AuthorizationApi {

    public static final Set<UUID> authentificatedUsers = new HashSet<>();

    @Override
    public boolean isAuthentificated(Player player) {
        return authentificatedUsers.contains(player.getUniqueId());
    }
}
