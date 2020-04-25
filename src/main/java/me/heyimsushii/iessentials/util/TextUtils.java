package me.heyimsushii.iessentials.util;

public class TextUtils {

    public static String argsToString(String[] args) {
        StringBuilder result = new StringBuilder();
        for (String arg : args) result.append(arg);
        return result.toString();
    }
}