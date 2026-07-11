package com.example.libraryhtn.controller;

import com.example.libraryhtn.dto.BookDto;
import com.example.libraryhtn.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/book")
public class BookShelfController {

    private final BookService bookService;

    @GetMapping("/all")
    public List<BookDto> getAll() {
        return bookService.getAll();
    }

    @GetMapping("/{id}")
    public BookDto get(@PathVariable String id) {
        return bookService.getById(id);
    }

    @PostMapping
    public BookDto add(@RequestBody BookDto request) {
        return bookService.add(request);
    }

    @PatchMapping
    public BookDto edit(@RequestBody BookDto request) {
        return bookService.edit(request);
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable String id) {
        bookService.remove(id);
    }

}
