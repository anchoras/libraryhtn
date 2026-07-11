package com.example.libraryhtn.dto;

import com.example.libraryhtn.enums.BookFormat;

import java.util.UUID;

public record BookDto(
        UUID id,
        String title,
        String creator,
        String tags,
        Boolean isRead,
        BookFormat format,
        String impressions
) {
}
