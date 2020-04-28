package me.heyimsushii.iessentials.command.commands;

import me.heyimsushii.iessentials.IEssentials;
import me.heyimsushii.iessentials.command.AbstractCommand;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandFeed extends AbstractCommand {

    @Override
    public String getCommand() {
        return "feed";
    }

    @Override
    public String getDescription() {
        return "Feeds a player.";
    }

    @Override
    public String getPermission() {
        return "iessentials.feed";
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

        target.setFoodLevel(20);
        target.sendMessage(IEssentials.getMessages().getMessage("player-fed").replace("{PLAYERNAME}", player.getName()));
    }
}