package com.example.libraryhtn.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

public enum BookFormat {

    PHYSICAL("physical"),
    AUDIO("audio"),
    EBOOK("ebook"),
    BORROWED("borrowed");

    private final String value;

    BookFormat(String value) {
        this.value = value;
    }

    @JsonValue
    public String toJson() {
        return value;
    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static BookFormat fromJson(String value) {
        return fromString(value);
    }

    public static BookFormat fromString(String value) {
        if (value == null) {
            return null;
        }
        return Arrays.stream(values())
                .filter(format -> format.value.equalsIgnoreCase(value)
                        || format.name().equalsIgnoreCase(value))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unknown format: " + value));
    }

}
