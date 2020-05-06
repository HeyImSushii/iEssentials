package me.heyimsushii.iessentials.command.commands;

import me.heyimsushii.iessentials.command.AbstractCommand;
import me.heyimsushii.iessentials.util.TextUtils;
import org.apache.commons.lang.StringUtils;
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
                player.sendMessage("the chat wasnt cleared");
                return;
            }
            return;
        }

        Bukkit.broadcastMessage(StringUtils.repeat("\n", 512));
        Bukkit.broadcastMessage(TextUtils.line(ChatColor.GRAY, 64));
        Bukkit.broadcastMessage(TextUtils.centerText("\n&e&lThe chat has been cleared!\n"));
        Bukkit.broadcastMessage(TextUtils.line(ChatColor.GRAY, 64));
    }
}
