package me.heyimsushii.iessentials.command.commands;

import me.heyimsushii.iessentials.command.AbstractCommand;
import me.heyimsushii.iessentials.util.TextUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import javax.xml.soap.Text;
import java.util.stream.Collectors;

public class CommandList extends AbstractCommand {
    @Override
    public String getCommand() {
        return "list";
    }

    @Override
    public String getDescription() {
        return "Shows a list of online players.";
    }

    @Override
    public String getPermission() {
        return "iessentials.list";
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

        player.sendMessage(TextUtils.centerLineText("&7&m", "&e&lPlayers Online: " + Bukkit.getOnlinePlayers().size() + "/" + Bukkit.getMaxPlayers()));
        player.sendMessage(" ");
        player.sendMessage(Bukkit.getOnlinePlayers().stream().map(Player::getName).collect(Collectors.joining(", ")));
        player.sendMessage(" ");
        player.sendMessage(TextUtils.line(ChatColor.GRAY, 64));
    }
}