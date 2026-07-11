package com.example.libraryhtn.controller.dto.request;

import com.example.libraryhtn.enums.BookFormat;

public record BookFilter(
        String title,
        String creator,
        String tags,
        Boolean isRead,
        BookFormat format,
        String impressions
) {
}
