package com.example.libraryhtn.controller;

import com.example.libraryhtn.controller.dto.request.BookRequest;
import com.example.libraryhtn.dto.BookDto;
import lombok.val;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/book")
public class BookController {

    @PostMapping("/all")
    public List<BookDto> getAllBooks(@RequestBody BookRequest request) {
        val id = UUID.randomUUID();
        val idStr = id.toString().substring(0, 7);
        val theBook = new BookDto(id, "Random Book " + idStr, "Some Creator of " + idStr, List.of("romance", "18+","woman"), false, "Some impressions for " + idStr);
        return List.of(theBook);
    }

}
