package me.heyimsushii.iessentials.command.commands;

import me.heyimsushii.iessentials.command.AbstractCommand;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandList extends AbstractCommand {
    @Override
    public String getCommand() {
        return "list";
    }

    @Override
    public String getDescription() {
        return "Shows a list of online players.";
    }

    @Override
    public String getPermission() {
        return "iessentials.list";
    }

    @Override
    public String getUsage() {
        return "";
    }

    @Override
    public int getRequiredArgs() {
        return 0;
    }

    @Override
    public void execute(CommandSender sender, Command command, String commandName, String[] args) {
        Player player = (Player) sender;

        player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7&m+                  &e&lOnline Players&7&m                  +"));
        StringBuilder stringBuilder;
        stringBuilder = new StringBuilder();
        for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append(", ");
            }
            player.sendMessage(String.valueOf(stringBuilder.append(ChatColor.WHITE).append(onlinePlayer.getName()).append(ChatColor.GRAY)));
        }

        player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7&m+                                                          +"));
    }
}
