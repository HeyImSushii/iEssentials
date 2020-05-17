package me.heyimsushii.iessentials.data;

import me.heyimsushii.iessentials.IEssentials;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PlayerManager {

    private final Map<UUID, PlayerData> playerDataMap = new HashMap<>();

    private File getFileFor(UUID id) {
        return new File(IEssentials.getInstance().getDataFolder() + "/playerdata/", id + ".yml");
    }

    public void load(UUID id) {
        File file = getFileFor(id);
        PlayerData playerData = new PlayerData(id, YamlConfiguration.loadConfiguration(file));

        playerDataMap.put(id, playerData);
        save(id);
    }

    public PlayerData getPlayerData(UUID id) {
        if (!playerDataMap.containsKey(id)) {
            load(id);
        }

        return playerDataMap.get(id);
    }

    public void save(UUID id) {
        if (!playerDataMap.containsKey(id)) {
            return;
        }

        PlayerData data = playerDataMap.get(id);
        YamlConfiguration config = data.getConfig();

        try {
            config.save(getFileFor(id));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}