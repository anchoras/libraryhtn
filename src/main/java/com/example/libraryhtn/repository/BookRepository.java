package com.example.libraryhtn.repository;

import com.example.libraryhtn.controller.dto.request.BookFilter;
import com.example.libraryhtn.entity.Book;
import com.example.libraryhtn.repository.sql.BookRepositorySql;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
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
    private final static String FILTER = "filter";
    private final static String GENERAL_LIMIT = "general_limit";
    private final static String PARAMETER_LIMIT = "parameter_limit";

    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<Book> getAll() {
        return jdbcTemplate.query(BookRepositorySql.GET_ALL, (rs, rowNumber) -> loadBook(rs));
    }

    public List<Book> getStrictFiltered(BookFilter filter) {
        if (filter == null || filter.isBlank()) {
            return getAll();
        }

        val sql = new StringBuilder(BookRepositorySql.GET_STRICT_FILTERED_BASE);
        val params = new MapSqlParameterSource();

        if (filter.hasTitle()) {
            sql.append(" and title ilike :").append(TITLE);
            params.addValue(TITLE, "%" + filter.title() + "%");
        }
        if (filter.hasCreator()) {
            sql.append(" and creator ilike :").append(CREATOR);
            params.addValue(CREATOR, "%" + filter.creator() + "%");
        }
        if (filter.hasTags()) {
            sql.append(" and tags ilike :").append(TAGS);
            params.addValue(TAGS, "%" + filter.tags() + "%");
        }
        if (filter.hasIsRead()) {
            sql.append(" and is_read = :").append(IS_READ);
            params.addValue(IS_READ, filter.isRead());
        }
        if (filter.hasImpressions()) {
            sql.append(" and tags ilike :").append(TAGS);
            params.addValue(IMPRESSIONS, "%" + filter.tags() + "%");
        }

        return namedParameterJdbcTemplate.query(
                sql.toString(),
                params,
                (rs, rowNumber) -> loadBook(rs));
    }

    public List<Book> getVagueFiltered(String filter, Integer generalLimit, Integer parameterLimit) {
        val mapSqlParameterSource = new MapSqlParameterSource()
                .addValue(FILTER, "%" + filter + "%")
                .addValue(GENERAL_LIMIT, generalLimit)
                .addValue(PARAMETER_LIMIT, parameterLimit);
        return namedParameterJdbcTemplate.query(
                BookRepositorySql.GET_VAGUE_FILTERED,
                mapSqlParameterSource,
                (rs, rowNumber) -> loadBook(rs));
    }

    public Book save(Book book) {
        val mapSqlParameterSource = new MapSqlParameterSource()
                .addValue(TITLE, book.getTitle())
                .addValue(CREATOR, book.getCreator())
                .addValue(TAGS, book.getTags())
                .addValue(IS_READ, book.getIsRead())
                .addValue(IMPRESSIONS, book.getImpressions());
        return namedParameterJdbcTemplate.queryForObject(
                BookRepositorySql.SAVE,
                mapSqlParameterSource,
                new BeanPropertyRowMapper<>(Book.class));
    }

    private Book loadBook(ResultSet rs) throws SQLException {
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
