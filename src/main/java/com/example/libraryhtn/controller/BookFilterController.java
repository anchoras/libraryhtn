package com.example.libraryhtn.controller;

import com.example.libraryhtn.controller.dto.request.BookRequest;
import com.example.libraryhtn.dto.BookDto;
import com.example.libraryhtn.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/book/filter")
public class BookFilterController {

    private final BookService bookService;

    @PostMapping
    public List<BookDto> getStrictFiltered(@RequestBody BookRequest request) {
        return bookService.getStrictFiltered(request);
    }

    @GetMapping
    public List<BookDto> getFiltered(@RequestParam String request) {
        return bookService.getVagueFiltered(request);
    }

}
