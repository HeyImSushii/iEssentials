package me.heyimsushii.iessentials.command;

import me.heyimsushii.iessentials.IEssentials;
import me.heyimsushii.iessentials.command.commands.CommandGamemode;
import me.heyimsushii.iessentials.command.commands.CommandHelp;
import me.heyimsushii.iessentials.command.commands.CommandPing;

import java.util.HashMap;
import java.util.Map;

public class CommandRegister {

    private Map<String, AbstractCommand> commands = new HashMap<>();

    public CommandRegister() {
        addCommand("help", new CommandHelp());
        addCommand("ping", new CommandPing());
        addCommand("gamemode", new CommandGamemode());

        for (AbstractCommand command : commands.values()) {
            IEssentials.getInstance().getCommand(command.getCommand()).setExecutor(command);
        }
    }

    private void addCommand(String commandName, AbstractCommand abstractCommand) {
        if (!commands.containsValue(abstractCommand)) {
            commands.put(commandName, abstractCommand);
        }
    }

    public Map<String, AbstractCommand> getCommands() {
        return commands;
    }
}