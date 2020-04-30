package me.heyimsushii.iessentials;

import me.heyimsushii.iessentials.command.CommandRegister;
import me.heyimsushii.iessentials.config.Config;
import me.heyimsushii.iessentials.config.Messages;
import me.heyimsushii.iessentials.events.PlayerChat;
import me.heyimsushii.iessentials.events.PlayerJoin;
import me.heyimsushii.iessentials.events.PlayerLeave;
import me.heyimsushii.iessentials.events.PlayerLogin;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class IEssentials extends JavaPlugin {

    private static IEssentials instance;
    private static CommandRegister commandRegister;
    private static Config config;
    private static Messages messages;

    @Override
    public void onEnable() {
        instance = this;
        commandRegister = new CommandRegister();
        config = new Config();
        messages = new Messages();

        if (!getDataFolder().exists()) getDataFolder().mkdirs();

        config.load();
        messages.load();

        registerEvents();
    }

    @Override
    public void onDisable() {
        instance = null;
        commandRegister = null;
    }

    private void registerEvents() {
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new PlayerJoin(), this);
        pm.registerEvents(new PlayerLeave(), this);
        pm.registerEvents(new PlayerLogin(), this);
        pm.registerEvents(new PlayerChat(), this);
    }

    public static IEssentials getInstance() {
        return instance;
    }

    public static CommandRegister getCommandRegister() {
        return commandRegister;
    }

    public static Config getConfigFile() {
        return config;
    }

    public static Messages getMessages() {
        return messages;
    }
}
