package me.heyimsushii.iessentials.command.commands;

import me.heyimsushii.iessentials.IEssentials;
import me.heyimsushii.iessentials.command.AbstractCommand;
import me.heyimsushii.iessentials.lang.Lang;
import me.heyimsushii.iessentials.util.TextUtils;
import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandBan extends AbstractCommand {

    @Override
    public String getCommand() {
        return "ban";
    }

    @Override
    public String getDescription() {
        return "Bans a player.";
    }

    @Override
    public String getPermission() {
        return "iessentials.ban";
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
            Lang.sendMessage(player, Lang.PLAYER_NOT_FOUND);
            return;
        }

        if (target.isOp()) {
            Lang.sendMessage(player, Lang.PLAYER_NOT_BANNABLE);
            return;
        }

        if (target.isBanned()) {
            Lang.sendMessage(player, Lang.PLAYER_ALREADY_BANNED);
            return;
        }

        Bukkit.getBanList(BanList.Type.NAME).addBan(target.getName(), TextUtils.concatenateArgs(args, 1), null, null);
        target.getPlayer().kickPlayer(TextUtils.concatenateArgs(args, 1));
        Lang.sendMessage(player, Lang.PLAYER_BANNED);
    }
}