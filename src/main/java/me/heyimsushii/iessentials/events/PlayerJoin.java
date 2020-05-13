package me.heyimsushii.iessentials.events;

import me.heyimsushii.iessentials.IEssentials;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        IEssentials.getPlayerManager().load(player.getUniqueId());
        IEssentials.getPlayerManager().getPlayerData(player.getUniqueId()).setPlayerName(player.getName());
        IEssentials.getPlayerManager().getPlayerData(player.getUniqueId()).setUUID(player.getUniqueId());

        if (IEssentials.getConfigFile().getConfig().getBoolean("enable-custom-join-message")) {
            event.setJoinMessage(ChatColor.translateAlternateColorCodes('&', IEssentials.getConfigFile().getConfig().getString("custom-join-message")
                    .replace("{PLAYERNAME}", player.getName())));
        }
    }
}