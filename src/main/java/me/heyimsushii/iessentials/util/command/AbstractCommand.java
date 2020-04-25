package me.heyimsushii.iessentials.util.command;

import me.heyimsushii.iessentials.util.lang.Lang;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public abstract class AbstractCommand implements CommandExecutor {

    public abstract String getCommand();

    public abstract String getDescription();

    public abstract String getPermission();

    public abstract String getUsage();

    public abstract int getRequiredArgs();

    public boolean onCommand(CommandSender sender, Command command, String commandName, String[] args) {
        Player player = (Player) sender;

        if (!(sender.hasPermission(getPermission()))) {
            player.sendMessage(Lang.NO_PERMISSION.getMessage());
            return true;
        }

        if (args.length < getRequiredArgs()) {
            player.sendMessage(Lang.INVALID_ARGS.getMessage());
            return true;
        }
        execute(sender, command, commandName, args);
        return true;
    }

    public abstract void execute(CommandSender sender, Command command, String commandName, String[] args);
}
