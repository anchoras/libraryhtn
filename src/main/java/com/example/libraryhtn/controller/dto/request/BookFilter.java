package com.example.libraryhtn.controller.dto.request;

import java.util.List;

public record BookFilter(
        String title,
        String creator,
        List<String> tags,
        Boolean isRead
) {
}
