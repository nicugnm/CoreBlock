package ro.coreblock.implementation.protection.attack;

import org.bukkit.entity.Player;
import ro.coreblock.api.protection.ProtectionApi;

public class AttackOnProtection implements ProtectionApi {

    @Override
    public boolean isProtected(Player player) {
        return player.isOp() || !(player.isInWater() || player.isInLava());
    }
}
