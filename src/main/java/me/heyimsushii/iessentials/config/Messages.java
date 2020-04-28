package me.heyimsushii.iessentials.config;

import me.heyimsushii.iessentials.IEssentials;
import org.bukkit.ChatColor;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class Messages {

    private File file;
    private YamlConfiguration config = new YamlConfiguration();

    public void load() {
        file = new File(IEssentials.getInstance().getDataFolder(), "messages.yml");
        if (!file.exists()) {
            try {
                file.createNewFile();

                config.options().header("# Message File for iEssentials v1.1.0");

                /* Prefix */
                set("prefix", "&8&l| &e&liEssentials &8&l| ");

                /* Error Messages */
                set("no-permission", getMessageRaw("prefix") + "&4Sorry, but you do not have the sufficient permission to do this.");
                set("invalid-args", getMessageRaw("prefix") + "&7/{COMMAND} {USAGE}");

                /* Other */
                set("ping-message", getMessageRaw("prefix") + "&7Pong!");
                set("gamemode-changed", getMessageRaw("prefix") + "&7You are now in &6{GAMEMODE}");
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

    public String getMessageRaw(String path) {
        return config.getString(path);
    }

    public String getMessage(String path) {
        return ChatColor.translateAlternateColorCodes('&', config.getString(path));
    }

    public File getFile() {
        return file;
    }

    public YamlConfiguration getConfig() {
        return config;
    }
}
