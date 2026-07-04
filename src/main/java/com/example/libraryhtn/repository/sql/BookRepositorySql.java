package com.example.libraryhtn.repository.sql;

import lombok.experimental.UtilityClass;

@UtilityClass
public class BookRepositorySql {

    public static final String GET_ALL = "select * from book";

    public static final String GET_STRICT_FILTERED_BASE = "select * from book where 1=1";

    public static final String GET_VAGUE_FILTERED = """
            (
                select *
                from book
                where title like :filter
                limit :parameter_limit
            )
            union
            (
                select *
                from book
                where creator like :filter
                limit :parameter_limit
            )
            union
            (
                select *
                from book
                where tags like :filter
                limit :parameter_limit
            )
            union
            (
                select *
                from book
                where impressions like :filter
                limit :parameter_limit
            )
            limit :general_limit
            """;

    public static final String SAVE = """
            insert into book
            (title, creator, tags, is_read, impressions)
            values
            (:title, :creator, :tags, :is_read, :impressions)
            returning *
            """;

}
