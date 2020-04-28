package me.heyimsushii.iessentials.command;

import me.heyimsushii.iessentials.IEssentials;
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

        if (!(sender instanceof Player)) {
            sender.sendMessage(IEssentials.getMessages().getMessage("player-only-command"));
            return true;
        }

        if (!(sender.hasPermission(getPermission()))) {
            player.sendMessage(IEssentials.getMessages().getMessage("no-permission"));
            return true;
        }

        if (args.length < getRequiredArgs()) {
            player.sendMessage(IEssentials.getMessages().getMessage("invalid-args")
                    .replace("{COMMAND}", getCommand()).replace("{USAGE}", getUsage()));
            return true;
        }
        execute(sender, command, commandName, args);
        return true;
    }

    public abstract void execute(CommandSender sender, Command command, String commandName, String[] args);
}
