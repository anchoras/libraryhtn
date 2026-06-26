package com.example.libraryhtn.controller;

import com.example.libraryhtn.controller.dto.request.BookRequest;
import com.example.libraryhtn.dto.BookDto;
import com.example.libraryhtn.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/book")
public class BookController {

    private final BookService bookService;

    @GetMapping("/all")
    public List<BookDto> getAllBooks() {
        return bookService.getAll();
    }

    @PostMapping
    public List<BookDto> getStrictFilteredBooks(@RequestBody BookRequest request) {
        return bookService.getStrictFiltered(request);
    }

    @GetMapping
    public List<BookDto> getFilteredBooks(@RequestParam String request) {
        return bookService.getVagueFiltered(request);
    }

}
