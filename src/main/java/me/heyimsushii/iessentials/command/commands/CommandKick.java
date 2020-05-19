package me.heyimsushii.iessentials.command.commands;

import me.heyimsushii.iessentials.command.AbstractCommand;
import me.heyimsushii.iessentials.lang.Lang;
import me.heyimsushii.iessentials.util.TextUtils;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandKick extends AbstractCommand {

    @Override
    public String getCommand() {
        return "kick";
    }

    @Override
    public String getDescription() {
        return "Kicks a player.";
    }

    @Override
    public String getPermission() {
        return "iessentials.kick";
    }

    @Override
    public String getUsage() {
        return "<player> [reason]";
    }

    @Override
    public int getRequiredArgs() {
        return 1;
    }

    @Override
    public void execute(CommandSender sender, Command command, String commandName, String[] args) {
        Player player = (Player) sender;
        OfflinePlayer target = Bukkit.getPlayer(args[0]);

        if (target == null) {
            player.sendMessage(Lang.getMessage(Lang.PLAYER_NOT_FOUND));
            return;
        }

        if (target.isOp()) {
            player.sendMessage(Lang.getMessage(Lang.PLAYER_NOT_KICKABLE));
            return;
        }

        if (args[1].isEmpty()) {
            target.getPlayer().kickPlayer("No reason provided.");
            return;
        }

        target.getPlayer().kickPlayer(TextUtils.concatenateArgs(args, 1));
        player.sendMessage(Lang.getMessage(Lang.PLAYER_KICKED).replace("{PLAYERNAME}", target.getName()));
    }
}