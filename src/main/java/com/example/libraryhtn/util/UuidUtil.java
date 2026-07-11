package com.example.libraryhtn.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class UuidUtil {

    public static String normalize(String uuidString) {
        if (uuidString == null) {
            return null;
        }
        String normalized = uuidString.trim();
        if (normalized.length() >= 2
                && normalized.charAt(0) == '{'
                && normalized.charAt(normalized.length() - 1) == '}') {
            normalized = normalized.substring(1, normalized.length() - 1).trim();
        }
        return normalized;
    }

}
