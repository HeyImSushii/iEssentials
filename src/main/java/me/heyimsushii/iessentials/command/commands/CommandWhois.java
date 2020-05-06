package me.heyimsushii.iessentials.command.commands;

import me.heyimsushii.iessentials.command.AbstractCommand;
import me.heyimsushii.iessentials.util.TextUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandWhois extends AbstractCommand {

    @Override
    public String getCommand() {
        return "whois";
    }

    @Override
    public String getDescription() {
        return "Shows information about a player.";
    }

    @Override
    public String getPermission() {
        return "iessentials.whois";
    }

    @Override
    public String getUsage() {
        return "<player>";
    }

    @Override
    public int getRequiredArgs() {
        return 1;
    }

    @Override
    public void execute(CommandSender sender, Command command, String commandName, String[] args) {
        Player player = (Player) sender;
        Player target = Bukkit.getPlayer(args[0]);

        int x = target.getLocation().getBlockX();
        int y = target.getLocation().getBlockY();
        int z = target.getLocation().getBlockX();

        player.sendMessage(TextUtils.line(ChatColor.GRAY, 64));
        player.sendMessage(ChatColor.DARK_GRAY + "»" + ChatColor.YELLOW + " Player Name: " + ChatColor.GRAY + target.getName());
        player.sendMessage(ChatColor.DARK_GRAY + "»" + ChatColor.YELLOW + " IP Address: " + ChatColor.GRAY + target.getAddress().getHostName());
        player.sendMessage(ChatColor.DARK_GRAY + "»" + ChatColor.YELLOW + " Health: " + ChatColor.GRAY + target.getHealth() + "/" + target.getMaxHealth());
        player.sendMessage(ChatColor.DARK_GRAY + "»" + ChatColor.YELLOW + " Hunger: " + ChatColor.GRAY + target.getFoodLevel() + "/20");
        player.sendMessage(ChatColor.DARK_GRAY + "»" + ChatColor.YELLOW + " XP Level: " + ChatColor.GRAY + target.getLevel());
        player.sendMessage(ChatColor.DARK_GRAY + "»" + ChatColor.YELLOW + " Location: XZY: " + ChatColor.GRAY + x + " / " + y + " / " + z);
        player.sendMessage(ChatColor.DARK_GRAY + "»" + ChatColor.YELLOW + " Gamemode: " + ChatColor.GRAY + target.getGameMode().name().toLowerCase());
        player.sendMessage(ChatColor.DARK_GRAY + "»" + ChatColor.YELLOW + " Fly mode: " + ChatColor.GRAY + target.isFlying());
        player.sendMessage(TextUtils.line(ChatColor.GRAY, 64));
    }
}