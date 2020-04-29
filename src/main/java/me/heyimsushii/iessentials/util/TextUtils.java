package me.heyimsushii.iessentials.util;

import com.google.common.base.Strings;
import org.apache.commons.lang.StringUtils;
import org.bukkit.ChatColor;

import java.util.Arrays;

public class TextUtils {

    public static String concatenateArgs(String[] args, int startIndex) {
        return String.join(" ", Arrays.copyOfRange(args, startIndex, args.length));
    }

    public static String line(int length) {
        return String.format("%s%s", ChatColor.GRAY + "" + ChatColor.STRIKETHROUGH, Strings.repeat(" ", length));
    }

    public static String centerText(String content) {
        int maxWidth = 64;
        int spaces = (int) Math.round((maxWidth - 1.4 * ChatColor.stripColor(content).length()) / 2);
        return StringUtils.repeat(" ", spaces) + ChatColor.translateAlternateColorCodes('&', content);
    }
}