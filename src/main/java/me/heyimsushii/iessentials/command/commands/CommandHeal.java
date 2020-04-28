package me.heyimsushii.iessentials.command.commands;

import me.heyimsushii.iessentials.IEssentials;
import me.heyimsushii.iessentials.command.AbstractCommand;
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

        target.setHealth(target.getHealthScale());
        target.sendMessage(IEssentials.getMessages().getMessage("player-healed").replace("{PLAYERNAME}", player.getName()));
    }
}