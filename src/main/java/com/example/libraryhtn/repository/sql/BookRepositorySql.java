package com.example.libraryhtn.repository.sql;

import lombok.experimental.UtilityClass;

@UtilityClass
public class BookRepositorySql {
    public static final String GET_ALL = "select * from book";
}
