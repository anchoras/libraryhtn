package com.example.libraryhtn.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

// Entity
@Getter
@Setter
public class Book {
    UUID id;
    String title;
    String creator;
    String tags;
    Boolean isRead;
    String impressions;
}
