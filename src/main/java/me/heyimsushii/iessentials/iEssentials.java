package me.heyimsushii.iessentials;

import me.heyimsushii.iessentials.commands.information.CommandHelp;
import me.heyimsushii.iessentials.util.command.CommandRegister;
import me.heyimsushii.iessentials.commands.CommandTest;
import org.bukkit.plugin.java.JavaPlugin;

public class iEssentials extends JavaPlugin {

    private static iEssentials iEssentials;
    private static CommandRegister commandRegister;

    @Override
    public void onEnable() {
        iEssentials = this;
        commandRegister = new CommandRegister();

        getCommand("test").setExecutor(new CommandTest());
        getCommand("help").setExecutor(new CommandHelp());
    }

    @Override
    public void onDisable() {
        iEssentials = null;
        commandRegister = null;
    }

    public static iEssentials getInstance() {
        return iEssentials;
    }

    public static CommandRegister getCommandRegister() {
        return commandRegister;
    }
}
