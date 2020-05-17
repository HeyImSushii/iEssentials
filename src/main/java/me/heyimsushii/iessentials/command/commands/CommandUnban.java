package me.heyimsushii.iessentials.command.commands;

import me.heyimsushii.iessentials.command.AbstractCommand;
import me.heyimsushii.iessentials.lang.Lang;
import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandUnban extends AbstractCommand {

    @Override
    public String getCommand() {
        return "unban";
    }

    @Override
    public String getDescription() {
        return "Unbans a player.";
    }

    @Override
    public String getPermission() {
        return "iessentials.unban";
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
        OfflinePlayer target = Bukkit.getPlayer(args[0]);

        if (target == null) {
            Lang.sendMessage(player, Lang.PLAYER_NOT_FOUND);
            return;
        }

        if (!target.isBanned()) {
            Lang.sendMessage(player, Lang.PLAYER_NOT_BANNED);
            return;
        }

        Bukkit.getBanList(BanList.Type.NAME).pardon(target.getName());
        Lang.sendMessage(player, Lang.PLAYER_UNBANNED);
    }
}