package me.heyimsushii.iessentials.command.commands;

import me.heyimsushii.iessentials.IEssentials;
import me.heyimsushii.iessentials.command.AbstractCommand;
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
        return "gamemode <survival|adventure|creative|spectator>";
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
                player.setGameMode(GameMode.SURVIVAL);
                player.sendMessage(IEssentials.getMessages().getMessage("gamemode-changed")
                        .replace("{GAMEMODE}", GameMode.SURVIVAL.name()));
                break;
            case "adventure":
                player.setGameMode(GameMode.ADVENTURE);
                player.sendMessage(IEssentials.getMessages().getMessage("gamemode-changed")
                        .replace("{GAMEMODE}", GameMode.ADVENTURE.name()));
                break;
            case "creative":
                player.setGameMode(GameMode.CREATIVE);
                player.sendMessage(IEssentials.getMessages().getMessage("gamemode-changed")
                        .replace("{GAMEMODE}", GameMode.CREATIVE.name()));
                break;
            case "spectator":
                player.setGameMode(GameMode.SPECTATOR);
                player.sendMessage(IEssentials.getMessages().getMessage("gamemode-changed")
                        .replace("{GAMEMODE}", GameMode.SPECTATOR.name()));
                break;
            default:
                player.sendMessage(IEssentials.getMessages().getMessage("invalid-args")
                        .replace("{COMMAND}", getCommand()).replace("{USAGE}", getUsage()));
                break;
        }
    }


    private void setGameMode(Player player, GameMode gameMode) {

    }
}
