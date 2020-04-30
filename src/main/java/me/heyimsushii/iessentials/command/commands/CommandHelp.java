package me.heyimsushii.iessentials.command.commands;

import me.heyimsushii.iessentials.IEssentials;
import me.heyimsushii.iessentials.command.AbstractCommand;
import me.heyimsushii.iessentials.util.TextUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandHelp extends AbstractCommand {

    public String getCommand() {
        return "help";
    }

    public String getDescription() {
        return "Shows a list of commands.";
    }

    public String getPermission() {
        return "iessentials.help";
    }

    public String getUsage() {
        return "";
    }

    public int getRequiredArgs() {
        return 0;
    }

    public void execute(CommandSender sender, Command command, String commandName, String[] args) {
        Player player = (Player) sender;
        player.sendMessage(TextUtils.line(64));
        for (AbstractCommand cmd : IEssentials.getCommandRegister().getCommands().values()) {
            player.sendMessage(ChatColor.YELLOW + "/" + cmd.getCommand() + " " + cmd.getUsage() + ChatColor.DARK_GRAY + " - " + ChatColor.GRAY + cmd.getDescription());
        }
        player.sendMessage(TextUtils.line(64));
    }
}