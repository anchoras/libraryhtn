package com.example.libraryhtn.service;

import com.example.libraryhtn.controller.dto.request.BookRequest;
import com.example.libraryhtn.dto.BookDto;
import com.example.libraryhtn.exception.BookNotFoundException;
import com.example.libraryhtn.mapper.BookMapper;
import com.example.libraryhtn.repository.BookRepository;
import com.example.libraryhtn.validator.BookValidator;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BookService {

    private final static Integer VAGUE_RESPONSE_GENERAL_LIMIT = 10;
    private final static Integer VAGUE_RESPONSE_PARAMETER_LIMIT = 3;

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;
    private final BookValidator bookValidator;

    public List<BookDto> getAll() {
        val bookList = bookRepository.getAll();
        return bookMapper.toDto(bookList);
    }

    public List<BookDto> getStrictFiltered(BookRequest request) {
        bookValidator.validateFilter(request);
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

    public BookDto add(BookDto bookDto) {
        bookValidator.validateAdd(bookDto);
        val book = bookMapper.toEntity(bookDto);
        val savedBook = bookRepository.create(book);
        return bookMapper.toDto(savedBook);
    }

    public BookDto edit(BookDto bookDto) {
        bookValidator.validateEdit(bookDto);
        val id = bookDto.id();
        if (bookRepository.existsById(id)) {
            val bookEdition = bookMapper.toEntity(bookDto);
            val savedBook = bookRepository.update(bookEdition);
            return bookMapper.toDto(savedBook);
        } else {
            throw new BookNotFoundException("There is no book with id " + id + " for editing");
        }
    }

    public void remove(String id) {
        bookValidator.validateId(id);
        val affectedRows = bookRepository.delete(UUID.fromString(id));
        if (affectedRows == 0) {
            throw new BookNotFoundException("There is no book with id " + id + " for deleting");
        }
    }

    public BookDto getById(String id) {
        bookValidator.validateId(id);
        val book = bookRepository.getById(UUID.fromString(id));
        if (book.isPresent()) {
            return bookMapper.toDto(book.get());
        } else {
            throw new BookNotFoundException("There is no book with id " + id);
        }
    }

}