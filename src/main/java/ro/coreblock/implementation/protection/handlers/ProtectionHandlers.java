package ro.coreblock.implementation.protection.handlers;

import lombok.extern.slf4j.Slf4j;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import ro.coreblock.api.config.LanguageType;
import ro.coreblock.implementation.config.utils.UtilityConfiguration;
import ro.coreblock.implementation.protection.ProtectionFactory;

@Slf4j
public class ProtectionHandlers implements Listener {

    @EventHandler
    public void onEntitySwim(PlayerMoveEvent event) {
        var player = event.getPlayer();
        ProtectionFactory protectionFactory = new ProtectionFactory();
        var protectionType = protectionFactory.getProtectionType(ProtectionFactory.ProtectionType.LAVA_WATER);
        var potionEffect = new PotionEffect(PotionEffectType.POISON, 5 * 20, 3);
        if (!protectionType.isProtected(player) && !player.hasPotionEffect(potionEffect.getType())) {
            player.addPotionEffect(potionEffect);

            var titleMessage= getMessageFromConfiguration(LanguageType.EN, "player.swimming.title");
            var subTitleMessage= getMessageFromConfiguration(LanguageType.EN, "player.swimming.subtitle");

            player.sendTitle(titleMessage, subTitleMessage);
        }
    }

    private String getMessageFromConfiguration(LanguageType languageType, String message) {
        return UtilityConfiguration.PROTECTION_CONFIGURATION.stream()
                .filter(objectConfiguration -> objectConfiguration.getLanguageType() == languageType)
                .findFirst()
                .get()
                .getLanguageSet().get(message);

    }
}
