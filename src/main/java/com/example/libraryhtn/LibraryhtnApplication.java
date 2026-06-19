package com.example.libraryhtn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.liquibase.autoconfigure.LiquibaseAutoConfiguration;

@SpringBootApplication(exclude = { LiquibaseAutoConfiguration.class })
public class LibraryhtnApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibraryhtnApplication.class, args);
    }

}
