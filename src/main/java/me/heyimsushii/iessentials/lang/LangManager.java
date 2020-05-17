package me.heyimsushii.iessentials.lang;

import me.heyimsushii.iessentials.IEssentials;
import me.heyimsushii.iessentials.lang.Lang;
import org.bukkit.ChatColor;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class LangManager {

    private final File file = new File(IEssentials.getInstance().getDataFolder(), "messages.yml");
    private final YamlConfiguration config = new YamlConfiguration();

    public void load() {
        if (!file.exists()) try {
            file.createNewFile();

            config.options().header("Message File for iEssentials v1");
            for (Lang lang : Lang.values()) set(lang.getPrefix(), lang.getMessage());
            save();
        } catch (IOException e) {
            e.printStackTrace();
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
