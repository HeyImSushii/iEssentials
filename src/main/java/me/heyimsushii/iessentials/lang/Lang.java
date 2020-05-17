package me.heyimsushii.iessentials.lang;

import me.heyimsushii.iessentials.IEssentials;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public enum Lang {

    /* Plugin */
    PREFIX("prefix", "&8&l| &e&liEssentials &8&l| "),

    /* Messages */
    PING_MESSAGE("ping-message", PREFIX.message + "&7Pong!"),
    PLAYER_HEALED("player-healed", PREFIX.message + "&7You have been healed."),
    PLAYER_FED("player-fed", PREFIX.message + "&7You have been fed."),
    GAMEMODE_CHANGED("gamemode-changed", PREFIX.message + "&7You are now in &e{GAMEMODE} mode."),
    PLAYER_BANNED("player-banned", PREFIX.message + "&7The player &e{PLAYERNAME} &7has been banned."),
    PLAYER_KICKED("player-kicked", PREFIX.message + "&7The player &e{PLAYERNAME} &7has been kicked."),
    PLAYER_UNBANNED("player-unbanned", PREFIX.message + "&7The player &e{PLAYERNAME} &7has been unbanned."),
    GODMODE_ENABLED("godmode-enabled", PREFIX.message + "&7You are now in &egod mode&7."),
    GODMODE_DISABLED("godmode-disabled", PREFIX.message + "&7You are no longer in &egod mode&7."),
    FLY_ENABLED("fly-enabled", PREFIX.message + "&7Flight mode is now &enabled&7."),
    FLY_DISABLED("fly-disabled", PREFIX.message + "&7Flight mode is now &edisabled&7."),


    /* Errors */
    NO_PERMISSION("no-permission", PREFIX.message + "&4Sorry, but you do not have the sufficient permission to do this."),
    PLAYER_ONLY("player-only", PREFIX.message + "&4You must be a player in order to execute this command!"),
    INVALID_ARGS("invalid-args", PREFIX.message + "&7/{COMMAND} {USAGE}"),
    PLAYER_NOT_FOUND("player-not-found", PREFIX.message + "&4Player not found."),
    PLAYER_ALREADY_BANNED("player-already-banned", PREFIX.message + "&4Player is already banned."),
    PLAYER_NOT_BANNABLE("player-not-bannable", PREFIX.message + "&4You cannot ban this player."),
    PLAYER_NOT_KICKABLE("player-not-kickable", PREFIX.message + "&4You cannot kick this player."),
    PLAYER_NOT_BANNED("player-not-banned", PREFIX.message + "&7The player &e{PLAYERNAME} &7is not banned.");

    public final String prefix;
    public final String message;

    Lang(String prefix, String message) {
        this.prefix = prefix;
        this.message = message;
    }

    public String getPrefix() {
        return prefix;
    }

    public String getMessage() {
        return message;
    }

    public static void sendMessage(Player player, Lang lang) {
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', IEssentials.getLangManager().getConfig().getString(lang.getPrefix())));
    }
}
