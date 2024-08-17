package com.greem4.util;

public class StringUtils {
    private static final String EMPTY = "";

    public static String trim(String value) {
        return value == null ? EMPTY : value.trim();
    }
}