package me.heyimsushii.iessentials.events;

import me.heyimsushii.iessentials.IEssentials;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerLeave implements Listener {

    @EventHandler
    public void onLeave(PlayerQuitEvent event) {
        Player player = event.getPlayer();

        if (IEssentials.getConfigFile().getConfig().getString("enable-custom-quit-message").equals(true))
            event.setQuitMessage(IEssentials.getConfigFile().getConfig().getString("custom-quit-message").replace("{PLAYERNAME}", player.getName()));
    }
}
