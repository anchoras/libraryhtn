package com.example.libraryhtn.repository;

import com.example.libraryhtn.entity.Book;
import com.example.libraryhtn.repository.sql.BookRepositorySql;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class BookRepository {

    private final static String ID = "id";
    private final static String TITLE = "title";
    private final static String CREATOR = "creator";
    private final static String TAGS = "tags";
    private final static String IS_READ = "is_read";
    private final static String IMPRESSIONS = "impressions";

    private final JdbcTemplate jdbcTemplate;

    public List<Book> getAll() {
        return jdbcTemplate.query(BookRepositorySql.GET_ALL, (rs, rowNumber) -> loadBookList(rs));
    }

    private Book loadBookList(ResultSet rs) throws SQLException {
        val book = new Book();
        book.setId(UUID.fromString(rs.getString(ID)));
        book.setTitle(rs.getString(TITLE));
        book.setCreator(rs.getString(CREATOR));
        book.setTags(rs.getString(TAGS));
        book.setIsRead(rs.getBoolean(IS_READ));
        book.setImpressions(rs.getString(IMPRESSIONS));

        return book;
    }

}
