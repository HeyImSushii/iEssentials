package me.heyimsushii.iessentials.commands.information;

import me.heyimsushii.iessentials.iEssentials;
import me.heyimsushii.iessentials.util.command.AbstractCommand;
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
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7&m+                       &e&lHelp&7&m                       +"));
        for (AbstractCommand cmd : iEssentials.getCommandRegister().getCommandMap().values()) {
            player.sendMessage(ChatColor.YELLOW + "/" + cmd.getCommand() + " " + cmd.getUsage() + ChatColor.DARK_GRAY + " - " + ChatColor.GRAY + cmd.getDescription());
        }
    }
}
