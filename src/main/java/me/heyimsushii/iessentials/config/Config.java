package me.heyimsushii.iessentials.config;

import me.heyimsushii.iessentials.IEssentials;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class Config {

    private final File file = new File(IEssentials.getInstance().getDataFolder(), "config.yml");
    private final YamlConfiguration config = new YamlConfiguration();

    public void load() {
        if (!file.exists()) {
            try {
                file.createNewFile();

                config.options().header("Config File for iEssentials v1.1.0");

                /* Chat */
                set("enable-custom-join-message", false);
                set("custom-join-message", "&e{PLAYERNAME} joined.");

                set("enable-custom-quit-message", false);
                set("custom-quit-message", "&e{PLAYERNAME} left.");

                set("enable-custom-chat-format", false);
                set("custom-chat-format", "{DISPLAYNAME} &8» &r{MESSAGE}");
                save();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            config.load(file);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }

    private void save() {
        try {
            config.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void set(String path, Object value) {
        config.set(path, value);
        save();
    }

    public File getFile() {
        return file;
    }

    public YamlConfiguration getConfig() {
        return config;
    }
}