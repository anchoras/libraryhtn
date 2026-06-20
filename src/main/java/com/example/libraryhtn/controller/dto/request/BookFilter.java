package com.example.libraryhtn.controller.dto.request;

public record BookFilter(
        String title,
        String creator,
        String tags,
        Boolean isRead
) {
}
