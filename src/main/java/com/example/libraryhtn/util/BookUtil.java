package com.example.libraryhtn.util;

import com.example.libraryhtn.controller.dto.request.BookFilter;
import com.example.libraryhtn.dto.BookDto;
import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.StringUtils;

@UtilityClass
public class BookUtil {

    public static Boolean isEmpty(BookFilter filter) {
        return filter.title() == null
                && filter.creator() == null
                && filter.tags() == null
                && filter.isRead() == null
                && filter.impressions() == null;
    }

    public static Boolean isEmpty(BookDto book) {
        return book.title() == null
                && book.creator() == null
                && book.tags() == null
                && book.isRead() == null
                && book.impressions() == null;
    }

    public Boolean isBlank(BookFilter filter) {
        return isEmpty(filter)
                || (StringUtils.isBlank(filter.title())
                && StringUtils.isBlank(filter.creator())
                && StringUtils.isBlank(filter.tags())
                && filter.isRead() == null
                && StringUtils.isBlank(filter.impressions()));
    }

    public Boolean isBlank(BookDto book) {
        return isEmpty(book)
                || (StringUtils.isBlank(book.title())
                && StringUtils.isBlank(book.creator())
                && StringUtils.isBlank(book.tags())
                && book.isRead() == null
                && StringUtils.isBlank(book.impressions()));
    }

    public Boolean hasTitle(BookFilter filter) {
        return filter.title() != null
                && !StringUtils.isBlank(filter.title());
    }

    public Boolean hasTitle(BookDto book) {
        return book.title() != null
                && !StringUtils.isBlank(book.title());
    }

    public Boolean hasBlankTitle(BookDto book) {
        return book.title() != null
                && StringUtils.isBlank(book.title());
    }

    public Boolean hasCreator(BookFilter filter) {
        return filter.creator() != null
                && !StringUtils.isBlank(filter.creator());
    }

    public Boolean hasBlankCreator(BookDto book) {
        return book.creator() != null
                && StringUtils.isBlank(book.creator());
    }

    public Boolean hasCreator(BookDto book) {
        return book.creator() != null
                && !StringUtils.isBlank(book.creator());
    }

    public Boolean hasTags(BookFilter filter) {
        return filter.tags() != null
                && !StringUtils.isBlank(filter.tags());
    }

    public Boolean hasTags(BookDto book) {
        return book.tags() != null
                && !StringUtils.isBlank(book.tags());
    }

    public Boolean hasIsRead(BookFilter filter) {
        return filter.isRead() != null;
    }

    public Boolean hasIsRead(BookDto book) {
        return book.isRead() != null;
    }

    public Boolean hasImpressions(BookFilter filter) {
        return filter.impressions() != null
                && !StringUtils.isBlank(filter.impressions());
    }

    public Boolean hasImpressions(BookDto book) {
        return book.impressions() != null
                && !StringUtils.isBlank(book.impressions());
    }

}
