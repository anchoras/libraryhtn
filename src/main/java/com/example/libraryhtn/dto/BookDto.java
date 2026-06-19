package com.example.libraryhtn.dto;

import java.util.List;
import java.util.UUID;

public record BookDto(
        UUID id,
        String title,
        String creator,
        List<String> tags,
        Boolean isRead,
        String impressions
) {
}
