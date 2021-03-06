package me.heyimsushii.iessentials.command;

import me.heyimsushii.iessentials.lang.Lang;
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
            player.sendMessage(Lang.getMessage(Lang.NO_PERMISSION));
            return true;
        }

        if (args.length < getRequiredArgs()) {
            player.sendMessage(Lang.getMessage(Lang.INVALID_ARGS).replace("{COMMAND}", getCommand()).replace("{USAGE}", getUsage()));
            return true;
        }
        execute(sender, command, commandName, args);
        return true;
    }

    public abstract void execute(CommandSender sender, Command command, String commandName, String[] args);
}
