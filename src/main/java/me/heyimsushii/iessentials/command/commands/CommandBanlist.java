package me.heyimsushii.iessentials.command.commands;

import me.heyimsushii.iessentials.command.AbstractCommand;
import me.heyimsushii.iessentials.util.TextUtils;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.stream.Collectors;

public class CommandBanlist extends AbstractCommand {
    @Override
    public String getCommand() {
        return "banlist";
    }

    @Override
    public String getDescription() {
        return "Shows a list of banned players.";
    }

    @Override
    public String getPermission() {
        return "iessentials.banlist";
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

        if (Bukkit.getBannedPlayers().isEmpty()) {
            player.sendMessage(TextUtils.line(64));
            player.sendMessage(" ");
            player.sendMessage(TextUtils.centerText("&e&lThere is no banned players"));
            player.sendMessage(" ");
            player.sendMessage(TextUtils.line(64));
            return;
        }
        player.sendMessage(TextUtils.line(64));
        player.sendMessage(" ");
        player.sendMessage(TextUtils.centerText("&e&lBanned Players: " + Bukkit.getBannedPlayers().size()));
        player.sendMessage(" ");
        player.sendMessage(Bukkit.getBannedPlayers().stream().map(OfflinePlayer::getName).collect(Collectors.joining(", ")));
        player.sendMessage(" ");
        player.sendMessage(TextUtils.line(64));
    }
}