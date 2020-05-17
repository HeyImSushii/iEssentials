package me.heyimsushii.iessentials.command.commands;

import me.heyimsushii.iessentials.IEssentials;
import me.heyimsushii.iessentials.command.AbstractCommand;
import me.heyimsushii.iessentials.lang.Lang;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandHeal extends AbstractCommand {

    @Override
    public String getCommand() {
        return "heal";
    }

    @Override
    public String getDescription() {
        return "Heals a player.";
    }

    @Override
    public String getPermission() {
        return "iessentials.heal";
    }

    @Override
    public String getUsage() {
        return "[player]";
    }

    @Override
    public int getRequiredArgs() {
        return 0;
    }

    @Override
    public void execute(CommandSender sender, Command command, String commandName, String[] args) {
        Player player = (Player) sender;
        Player target = Bukkit.getPlayer(args[1]);

        if (args.length == 0) {
            player.setHealth(player.getHealthScale());
            Lang.sendMessage(player, Lang.PLAYER_HEALED);
        } else {
            target.setHealth(target.getHealthScale());
            Lang.sendMessage(target, Lang.PLAYER_HEALED);
        }
    }
}