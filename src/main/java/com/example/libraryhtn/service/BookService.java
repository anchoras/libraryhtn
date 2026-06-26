package com.example.libraryhtn.service;

import com.example.libraryhtn.controller.dto.request.BookRequest;
import com.example.libraryhtn.dto.BookDto;
import com.example.libraryhtn.exception.BookFilterException;
import com.example.libraryhtn.mapper.BookMapper;
import com.example.libraryhtn.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final static Integer VAGUE_RESPONSE_GENERAL_LIMIT = 10;
    private final static Integer VAGUE_RESPONSE_PARAMETER_LIMIT = 3;

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    public List<BookDto> getAll() {
        val bookList = bookRepository.getAll();
        return bookMapper.toDto(bookList);
    }

    public List<BookDto> getStrictFiltered(BookRequest request) {
        if (request == null || request.bookFilter().isBlank()) {
            throw new BookFilterException("There is no any input in the filter");
        }

        val bookList = bookRepository.getStrictFiltered(request.bookFilter());
        return bookMapper.toDto(bookList);
    }

    public List<BookDto> getVagueFiltered(String request) {
        val bookList = bookRepository.getVagueFiltered(
                request,
                VAGUE_RESPONSE_GENERAL_LIMIT,
                VAGUE_RESPONSE_PARAMETER_LIMIT);
        return bookMapper.toDto(bookList);
    }

}