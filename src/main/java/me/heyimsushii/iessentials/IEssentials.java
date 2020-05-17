package me.heyimsushii.iessentials;

import me.heyimsushii.iessentials.events.*;
import me.heyimsushii.iessentials.data.PlayerManager;
import me.heyimsushii.iessentials.command.CommandRegister;
import me.heyimsushii.iessentials.lang.LangManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class IEssentials extends JavaPlugin {

    private static IEssentials instance;
    private static CommandRegister commandRegister;
    private static Config config;

    private static PlayerManager playerManager;
    private static LangManager langManager;

    @Override
    public void onEnable() {
        instance = this;
        commandRegister = new CommandRegister();
        config = new Config();

        playerManager = new PlayerManager();
        langManager = new LangManager();

        if (!getDataFolder().exists()) getDataFolder().mkdirs();

        config.load();
        langManager.load();

        registerEvents();
    }

    @Override
    public void onDisable() {
        instance = null;
        commandRegister = null;

        playerManager = null;
        langManager = null;
    }

    private void registerEvents() {
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new PlayerJoin(), this);
        pm.registerEvents(new PlayerLeave(), this);
        pm.registerEvents(new PlayerLogin(), this);
        pm.registerEvents(new PlayerChat(), this);
        pm.registerEvents(new PlayerDamage(), this);
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

    public static PlayerManager getPlayerManager() {
        return playerManager;
    }

    public static LangManager getLangManager() {
        return langManager;
    }
}