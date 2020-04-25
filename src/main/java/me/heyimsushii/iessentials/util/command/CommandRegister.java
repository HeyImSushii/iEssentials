package me.heyimsushii.iessentials.util.command;

import me.heyimsushii.iessentials.commands.CommandTest;
import me.heyimsushii.iessentials.commands.information.CommandHelp;

import java.util.HashMap;
import java.util.Map;

public class CommandRegister {

    private Map<String, AbstractCommand> commandMap = new HashMap<String, AbstractCommand>();

    public CommandRegister() {
        addCommand("test", new CommandTest());
        addCommand("help", new CommandHelp());
    }

    private void addCommand(String commandName, AbstractCommand abstractCommand) {
        if (!commandMap.containsValue(abstractCommand)) {
            commandMap.put(commandName, abstractCommand);
        }
    }

    public Map<String, AbstractCommand> getCommandMap() {
        return commandMap;
    }
}