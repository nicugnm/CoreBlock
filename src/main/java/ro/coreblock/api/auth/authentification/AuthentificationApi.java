package ro.coreblock.api.auth.authentification;

import org.bukkit.entity.Player;

public interface AuthentificationApi {

    void register(Player player);

    void login(Player player);
}
