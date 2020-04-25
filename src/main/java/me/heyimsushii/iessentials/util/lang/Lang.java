package me.heyimsushii.iessentials.util.lang;

import org.bukkit.ChatColor;

public enum Lang {

    /* Prefix */
    MAIN_PREFIX("main-prefix", "&8\u2502 &e&liEssentials&8\u2502 &7"),
    ERROR_PREFIX("error-prefix", "&8\u2502 &4&lError&8\u2502 &7"),
    INFORMATION_PREFIX("information-prefix", "&8\u2502 &e&lInformation&8\u2502 &7"),
    TELEPORT_PREFIX("teleport-prefix", "&8\u2502 &e&lTeleport&8\u2502 &7"),
    PUNISHMENT_PREFIX("punishment-prefix", "&8\u2502 &4&lPunishment&8\u2502 &7"),

    /* Error */
    NO_PERMISSION("no-permission", ERROR_PREFIX.value + "Sorry, but you do not have sufficient permission to do this."),

    /* Information */
    INVALID_ARGS("invalid-args", INFORMATION_PREFIX.value + "/%usage%");

    private String key;
    private String value;

    Lang(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    public String getMessage() {
        return ChatColor.translateAlternateColorCodes('&', value);
    }
}