package me.heyimsushii.iessentials.command.commands;

import me.heyimsushii.iessentials.IEssentials;
import me.heyimsushii.iessentials.command.AbstractCommand;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandPing extends AbstractCommand {
    @Override
    public String getCommand() {
        return "ping";
    }

    @Override
    public String getDescription() {
        return "Returns 'Pong!'";
    }

    @Override
    public String getPermission() {
        return "iessentials.ping";
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
        player.sendMessage(IEssentials.getMessages().getMessage("ping-message"));
    }
}
