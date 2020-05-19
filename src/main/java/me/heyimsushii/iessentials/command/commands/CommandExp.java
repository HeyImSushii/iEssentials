package me.heyimsushii.iessentials.command.commands;

import me.heyimsushii.iessentials.command.AbstractCommand;
import me.heyimsushii.iessentials.lang.Lang;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandExp extends AbstractCommand {

    @Override
    public String getCommand() {
        return "exp";
    }

    @Override
    public String getDescription() {
        return "Gives a certain amount of EXP points or levels to a player.";
    }

    @Override
    public String getPermission() {
        return "iessentials.exp";
    }

    @Override
    public String getUsage() {
        return "<player> <exp|level> <amount>";
    }

    @Override
    public int getRequiredArgs() {
        return 3;
    }

    @Override
    public void execute(CommandSender sender, Command command, String commandName, String[] args) {
        Player player = (Player) sender;
        Player target = Bukkit.getPlayer(args[1]);

        if (target == null) {
            player.sendMessage(Lang.getMessage(Lang.PLAYER_NOT_FOUND));
            return;
        }

        switch (args[2]) {
            case "exp":
                target.setExp(Float.parseFloat(args[2]));
                target.sendMessage(Lang.getMessage(Lang.EXP_POINTS_ADDED).replace("{AMOUNT}", args[2]));
                break;
            case "level":
                target.setLevel(target.getLevel() + Integer.parseInt(args[2]));
                target.sendMessage(Lang.getMessage(Lang.EXP_LEVEL_CHANGED).replace("{AMOUNT}", args[2]));
                break;
        }
    }
}
