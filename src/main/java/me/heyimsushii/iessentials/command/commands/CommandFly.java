package me.heyimsushii.iessentials.command.commands;

import me.heyimsushii.iessentials.IEssentials;
import me.heyimsushii.iessentials.command.AbstractCommand;
import me.heyimsushii.iessentials.lang.Lang;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandFly extends AbstractCommand {

    @Override
    public String getCommand() {
        return "fly";
    }

    @Override
    public String getDescription() {
        return "Toggles fly.";
    }

    @Override
    public String getPermission() {
        return "iessentials.fly";
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

        if (!player.isFlying()) {
            player.setFlying(true);
            player.setAllowFlight(true);
            Lang.sendMessage(player, Lang.FLY_ENABLED);
        } else {
            player.setFlying(false);
            player.setAllowFlight(false);
            Lang.sendMessage(player, Lang.FLY_DISABLED);
        }
    }
}