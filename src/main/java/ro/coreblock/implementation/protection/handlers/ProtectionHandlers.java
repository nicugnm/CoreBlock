package ro.coreblock.implementation.protection.handlers;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityToggleSwimEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import ro.coreblock.api.config.auth.LanguageType;
import ro.coreblock.implementation.config.utils.UtilityConfiguration;
import ro.coreblock.implementation.protection.ProtectionFactory;

import static ro.coreblock.implementation.utils.UtilityCore.PREFIX_MESSAGE;

public class ProtectionHandlers implements Listener {

    @EventHandler
    public void playerInsideWater(EntityToggleSwimEvent event) {
        if (!event.isSwimming()) return;
        if (!(event.getEntity() instanceof Player player)) return;

        ProtectionFactory protectionFactory = new ProtectionFactory();
        var protectionType = protectionFactory.getProtectionType(ProtectionFactory.ProtectionType.LAVA_WATER);
        if (!protectionType.isProtected(player)) {
            player.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 5, 1));
            String protectionMessage = PREFIX_MESSAGE;
            var message = getMessageFromConfiguration(LanguageType.EN, "player.swimming");

            protectionMessage = protectionMessage.replace("%message", message);
            player.sendMessage(protectionMessage);
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
