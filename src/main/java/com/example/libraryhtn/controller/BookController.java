package com.example.libraryhtn.controller;

import com.example.libraryhtn.controller.dto.request.BookRequest;
import com.example.libraryhtn.dto.BookDto;
import com.example.libraryhtn.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/book")
public class BookController {

    private final BookService bookService;

    @PostMapping("/all")
    public List<BookDto> getAllBooks(@RequestBody BookRequest request) {
        return bookService.getAll();
    }

}
