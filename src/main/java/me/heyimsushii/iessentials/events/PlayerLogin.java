package me.heyimsushii.iessentials.events;

import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

public class PlayerLogin implements Listener {

    @EventHandler
    public void onLogin(PlayerLoginEvent event) {
        Player player = event.getPlayer();

        if (player.isBanned()) {
            event.disallow(PlayerLoginEvent.Result.KICK_BANNED,
                    ChatColor.RED + "You have been banned!"
                            + ChatColor.GRAY + "\n\nBanned on: " + ChatColor.RESET + Bukkit.getBanList(BanList.Type.NAME).getBanEntry(player.getName()).getCreated()
                            + ChatColor.GRAY + "\nBanned by: " + ChatColor.RESET + Bukkit.getBanList(BanList.Type.NAME).getBanEntry(player.getName()).getTarget()
                            + ChatColor.GRAY + "\nReason: " + ChatColor.RESET + Bukkit.getBanList(BanList.Type.NAME).getBanEntry(player.getName()).getReason());
        }
        event.allow();
    }
}
