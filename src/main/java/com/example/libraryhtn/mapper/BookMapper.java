package com.example.libraryhtn.mapper;

import com.example.libraryhtn.dto.BookDto;
import com.example.libraryhtn.entity.Book;
import lombok.val;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookMapper {

    public Book toEntity(BookDto dto) {
        val book = new Book();
        book.setId(dto.id());
        book.setTitle(dto.title());
        book.setCreator(dto.creator());
        book.setTags(dto.tags());
        book.setIsRead(dto.isRead());
        book.setFormat(dto.format());
        book.setImpressions(dto.impressions());

        return book;
    }

    public List<Book> toEntity(List<BookDto> dtoList) {
        return dtoList.stream()
                .map(this::toEntity)
                .toList();
    }

    public BookDto toDto(Book entity) {
        return new BookDto(
                entity.getId(),
                entity.getTitle(),
                entity.getCreator(),
                entity.getTags(),
                entity.getIsRead(),
                entity.getFormat(),
                entity.getImpressions());
    }

    public List<BookDto> toDto(List<Book> entityList) {
        return entityList.stream()
                .map(this::toDto)
                .toList();
    }

}
