package me.heyimsushii.iessentials.command.commands;

import me.heyimsushii.iessentials.IEssentials;
import me.heyimsushii.iessentials.command.AbstractCommand;
import me.heyimsushii.iessentials.lang.Lang;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandGamemode extends AbstractCommand {
    @Override
    public String getCommand() {
        return "gamemode";
    }

    @Override
    public String getDescription() {
        return "Changes your gamemode.";
    }

    @Override
    public String getPermission() {
        return "iessentials.gamemode";
    }

    @Override
    public String getUsage() {
        return "<mode>";
    }

    @Override
    public int getRequiredArgs() {
        return 1;
    }

    @Override
    public void execute(CommandSender sender, Command command, String commandName, String[] args) {
        Player player = (Player) sender;
        switch (args[0]) {
            case "survival":
            case "0":
                setMode(player, GameMode.SURVIVAL);
                break;
            case "adventure":
            case "2":
                setMode(player, GameMode.ADVENTURE);
                break;
            case "creative":
            case "1":
                setMode(player, GameMode.CREATIVE);
                break;
            case "spectator":
            case "3":
                setMode(player, GameMode.SPECTATOR);
                break;
        }
    }

    private void setMode(Player player, GameMode gameMode) {
        player.setGameMode(gameMode);
        Lang.sendMessage(player, Lang.GAMEMODE_CHANGED);
    }
}