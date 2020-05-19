package me.heyimsushii.iessentials.data;

import me.heyimsushii.iessentials.IEssentials;
import org.bukkit.configuration.file.YamlConfiguration;

import java.util.UUID;

public class PlayerData {

    private final UUID uuid;
    private final YamlConfiguration config;

    public PlayerData(UUID uuid, YamlConfiguration config) {
        this.uuid = uuid;
        this.config = config;
    }

    public void set(String path, Object value) {
        config.set(path, value);
        IEssentials.getPlayerManager().save(getUuid());
    }

    public UUID getUuid() {
        return uuid;
    }

    public YamlConfiguration getConfig() {
        return config;
    }

    public String getPlayerName() {
        return config.getString("playerName");
    }

    public void setPlayerName(String playerName) {
        set("playerName", playerName);
    }

    public String getUUID() {
        return config.getString("uuid");
    }

    public void setUUID(UUID uuid) {
        set("uuid", uuid.toString());
    }

    public boolean getGodMode() {
        return config.getBoolean("godmode");
    }

    public void setGodMode(boolean godmode) {
        set("godmode", godmode);
    }

    public boolean getFly() {
        return config.getBoolean("fly");
    }

    public void setFly(boolean value) {
        set("fly", value);
    }
}