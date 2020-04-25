package me.heyimsushii.iessentials.commands;

import me.heyimsushii.iessentials.util.command.AbstractCommand;
import me.heyimsushii.iessentials.util.lang.Lang;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandTest extends AbstractCommand {
    public String getCommand() {
        return "test";
    }

    public String getDescription() {
        return "test command";
    }

    public String getPermission() {
        return "iessentials.test";
    }

    public String getUsage() {
        return "none";
    }

    public int getRequiredArgs() {
        return 0;
    }

    public void execute(CommandSender sender, Command command, String commandName, String[] args) {
        Player player = (Player) sender;
        for (Lang foo : Lang.values()) player.sendMessage(foo.getMessage());
        player.sendMessage("ikke faen robert");
    }
}