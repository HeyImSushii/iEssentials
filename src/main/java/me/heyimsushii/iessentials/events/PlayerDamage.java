package me.heyimsushii.iessentials.events;

import me.heyimsushii.iessentials.IEssentials;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class PlayerDamage implements Listener {

    @EventHandler
    public void onDamage(EntityDamageEvent event) {
        Entity player = event.getEntity();
        event.setCancelled(IEssentials.getPlayerManager().getPlayerData(player.getUniqueId()).getGodMode());
    }
}
