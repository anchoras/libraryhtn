package com.example.libraryhtn.dto;

import java.util.UUID;

public record BookDto(
        UUID id,
        String title,
        String creator,
        String tags,
        Boolean isRead,
        String impressions
) {
}
