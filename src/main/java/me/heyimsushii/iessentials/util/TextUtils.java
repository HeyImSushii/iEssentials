package me.heyimsushii.iessentials.util;

import com.google.common.base.Strings;
import org.apache.commons.lang.StringUtils;
import org.bukkit.ChatColor;

import java.util.Arrays;

public class TextUtils {

    public static String concatenateArgs(String[] args, int startIndex) {
        return String.join(" ", Arrays.copyOfRange(args, startIndex, args.length));
    }

    public static String line(ChatColor textColour, int length) {
        return String.format("%s%s", textColour + "" + ChatColor.STRIKETHROUGH, Strings.repeat(" ", length));
    }

    public static String centerText(String text) {
        int maxWidth = 64;
        int spaces = (int) Math.round((maxWidth - 1.4 * ChatColor.stripColor(text).length()) / 2);
        return StringUtils.repeat(" ", spaces) + ChatColor.translateAlternateColorCodes('&', text);
    }

    public static String centerLineText(String lineColour, String text) {
        int maxWidth = 64;
        int spaces = (int) Math.round((maxWidth - 1.4 * ChatColor.stripColor(text).length()) / 2);
        return Strings.repeat(ChatColor.translateAlternateColorCodes('&', lineColour) + " ", spaces)
                + ChatColor.translateAlternateColorCodes('&', "&r " + text + " &r")
                + Strings.repeat(ChatColor.translateAlternateColorCodes('&', lineColour) + " ", spaces);
    }
}