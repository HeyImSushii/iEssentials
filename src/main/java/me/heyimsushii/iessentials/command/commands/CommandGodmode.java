package me.heyimsushii.iessentials.command.commands;

import me.heyimsushii.iessentials.IEssentials;
import me.heyimsushii.iessentials.command.AbstractCommand;
import me.heyimsushii.iessentials.lang.Lang;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandGodmode extends AbstractCommand {

    @Override
    public String getCommand() {
        return "godmode";
    }

    @Override
    public String getDescription() {
        return "Toggles god mode.";
    }

    @Override
    public String getPermission() {
        return "iessentials.godmode";
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

        if (!IEssentials.getPlayerManager().getPlayerData(player.getUniqueId()).getGodMode()) {
            IEssentials.getPlayerManager().getPlayerData(player.getUniqueId()).setGodMode(true);
            player.sendMessage(Lang.getMessage(Lang.GODMODE_ENABLED));
        } else {
            IEssentials.getPlayerManager().getPlayerData(player.getUniqueId()).setGodMode(false);
            player.sendMessage(Lang.getMessage(Lang.GODMODE_DISABLED));
        }
    }
}