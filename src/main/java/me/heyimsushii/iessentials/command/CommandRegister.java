package me.heyimsushii.iessentials.command;

import me.heyimsushii.iessentials.IEssentials;
import me.heyimsushii.iessentials.command.commands.*;

import java.util.HashMap;
import java.util.Map;

public class CommandRegister {

    private final Map<String, AbstractCommand> commands = new HashMap<>();

    public CommandRegister() {
        addCommand("help", new CommandHelp());
        addCommand("ping", new CommandPing());
        addCommand("gamemode", new CommandGamemode());
        addCommand("whois", new CommandWhois());
        addCommand("list", new CommandList());
        addCommand("heal", new CommandHeal());
        addCommand("feed", new CommandFeed());
        addCommand("banlist", new CommandBanlist());
        addCommand("ban", new CommandBan());
        addCommand("kick", new CommandKick());
        addCommand("unban", new CommandUnban());
        addCommand("clearchat", new CommandClearchat());

        for (AbstractCommand command : commands.values())
            IEssentials.getInstance().getCommand(command.getCommand()).setExecutor(command);
    }

    private void addCommand(String commandName, AbstractCommand abstractCommand) {
        if (!commands.containsValue(abstractCommand)) commands.put(commandName, abstractCommand);
    }

    public Map<String, AbstractCommand> getCommands() {
        return commands;
    }
}