package me.heyimsushii.iessentials.config;

import me.heyimsushii.iessentials.IEssentials;
import org.bukkit.ChatColor;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class Messages {

    private final File file = new File(IEssentials.getInstance().getDataFolder(), "messages.yml");
    private final YamlConfiguration config = new YamlConfiguration();

    public void load() {
        if (!file.exists()) {
            try {
                file.createNewFile();

                config.options().header("# Message File for iEssentials v1");

                set("prefix", "&8&l| &e&liEssentials &8&l| ");

                set("player-only-command", getMessageRaw("prefix") + "&4You must be a player in order to execute this command!");
                set("no-permission", getMessageRaw("prefix") + "&4Sorry, but you do not have the sufficient permission to do this.");
                set("invalid-args", getMessageRaw("prefix") + "&7/{COMMAND} {USAGE}");
                set("ping-message", getMessageRaw("prefix") + "&7Pong!");
                set("gamemode-changed", getMessageRaw("prefix") + "&7You are now in &e{GAMEMODE} mode.");
                set("player-healed", getMessageRaw("prefix") + "&7You have been healed by &e{PLAYERNAME}.");
                set("player-fed", getMessageRaw("prefix") + "&7You have been fed by &e{PLAYERNAME}.");
                set("player-not-found", getMessage("prefix") + "&4Player not found.");
                set("player-already-banned", getMessage("prefix") + "&4Player is already banned.");
                set("player-not-bannable", getMessage("prefix") + "&4You cannot ban this player.");
                set("player-banned", getMessage("prefix") + "&7The player &e{PLAYERNAME} &7has been banned.");
                set("player-not-kickable", getMessage("prefix") + "&4You cannot kick this player.");
                set("player-kicked", getMessage("prefix") + "&7The player &e{PLAYERNAME} &7has been kicked.");
                set("player-not-banned", getMessage("prefix") + "&7The player &e{PLAYERNAME} &7is not banned.");
                set("player-unbanned", getMessage("prefix") + "&7The player &e{PLAYERNAME} &7has been unbanned.");
                set("fly-speed-changed", getMessage("prefix") + "&7Your fly speed is now &e{FLYSPEED}&7.");
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
