package me.heyimsushii.iessentials.events;

import me.heyimsushii.iessentials.IEssentials;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class PlayerChat implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        if (IEssentials.getConfigFile().getConfig().get("enable-custom-chat-format").equals(true)) {
            event.setFormat(IEssentials.getConfigFile().getConfig().get("custom-chat-format").toString());
        }
    }
}
