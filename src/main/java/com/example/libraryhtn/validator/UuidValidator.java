package com.example.libraryhtn.validator;

import java.util.regex.Pattern;

public class UuidValidator {

    // Regex for standard UUID format (8-4-4-4-12 hex digits)
    private static final Pattern UUID_REGEX =
            Pattern.compile("^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$");

    public static boolean isValidUUID(String uuidString) {
        if (uuidString == null || uuidString.isBlank()) {
            return false;
        }
        return UUID_REGEX.matcher(uuidString).matches();
    }

}
