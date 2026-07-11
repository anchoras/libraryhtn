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
            union
            (
                select *
                from book
                where format ilike :filter
                limit :parameter_limit
            )
            limit :general_limit
            """;

    public static final String CREATE = """
            insert into book
            (title, creator, tags, is_read, format, impressions)
            values
            (:title, :creator, :tags, :is_read, :format, :impressions)
            returning *
            """;

    public static final String GET_BY_ID = """
            select *
            from book
            where id = :id
            """;

    public static final String UPDATE = """
            update book
            set
                title = coalesce(:title, title),
                creator = coalesce(:creator, creator),
                tags = coalesce(:tags, tags),
                is_read = coalesce(:is_read, is_read),
                format = coalesce(:format, format),
                impressions = coalesce(:impressions, impressions)
            where id = :id
            returning *
            """;

    public static final String DELETE = """
            delete from book
            where id = :id
            """;

    public static final String EXISTS_BY_ID = """
        select exists(
            select 1
            from book
            where id = :id
        )
        """;

}
