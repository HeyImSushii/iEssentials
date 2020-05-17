package me.heyimsushii.iessentials.command.commands;

import me.heyimsushii.iessentials.command.AbstractCommand;
import me.heyimsushii.iessentials.util.TextUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandClearchat extends AbstractCommand {

    @Override
    public String getCommand() {
        return "clearchat";
    }

    @Override
    public String getDescription() {
        return "Clears the chat.";
    }

    @Override
    public String getPermission() {
        return "iessentials.clearchat";
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
        for (Player player : Bukkit.getOnlinePlayers()) {
            if (player.hasPermission("iessentials.bypass.chatclear")) {
                player.sendMessage(TextUtils.line(ChatColor.GRAY, 64));
                player.sendMessage(" ");
                player.sendMessage(TextUtils.centerText("&e&lThe chat was cleared, but not for you."));
                player.sendMessage(" ");
                player.sendMessage(TextUtils.line(ChatColor.GRAY, 64));
                return;
            }
            return;
        }

        for (int i = 0; i <= 512; i++) Bukkit.broadcastMessage(" ");

        Bukkit.broadcastMessage(TextUtils.line(ChatColor.GRAY, 64));
        Bukkit.broadcastMessage(" ");
        Bukkit.broadcastMessage(TextUtils.centerText("&e&lThe chat has been cleared!"));
        Bukkit.broadcastMessage(" ");
        Bukkit.broadcastMessage(TextUtils.line(ChatColor.GRAY, 64));
    }
}