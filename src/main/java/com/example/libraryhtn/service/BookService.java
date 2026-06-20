package com.example.libraryhtn.service;

import com.example.libraryhtn.dto.BookDto;
import com.example.libraryhtn.entity.Book;
import com.example.libraryhtn.mapper.BookMapper;
import com.example.libraryhtn.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    public List<BookDto> getAll() {
        val bookList = bookRepository.getAll();
        return bookMapper.toDto(bookList);
    }

}
