package com.example.libraryhtn.validator;

import com.example.libraryhtn.controller.constant.BookConstant;
import com.example.libraryhtn.controller.dto.request.BookFilter;
import com.example.libraryhtn.controller.dto.request.BookRequest;
import com.example.libraryhtn.dto.BookDto;
import com.example.libraryhtn.exception.BookFilterException;
import com.example.libraryhtn.exception.BookValidationException;
import com.example.libraryhtn.util.BookUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Component
public class BookValidator {

    private static final int STRING_LENGTH_MAX = 255;

    public void validateAdd(BookDto book) {
        if (book == null) {
            throw new BookValidationException("Request for book addition is null");
        }
        if (!BookUtil.hasTitle(book)) {
            throw new BookValidationException("There is no title in book addition request");
        }
        if (!BookUtil.hasCreator(book)) {
            throw new BookValidationException("There is no creator in book addition request");
        }
        validateStringLength(book);
    }

    public void validateEdit(BookDto book) {
        if (book == null) {
            throw new BookValidationException("Request for book edition is null");
        }
        if (book.id() == null) {
            throw new BookValidationException("Book id is null in book edition request");
        }
        if (BookUtil.isEmpty(book)) {
            throw new BookValidationException("All parameters are empty in book edition request");
        }
        if (BookUtil.hasBlankTitle(book)) {
            throw new BookValidationException("Title is blank in book edition request");
        }
        if (BookUtil.hasBlankCreator(book)) {
            throw new BookValidationException("Creator is blank in book edition request");
        }
        validateStringLength(book);
    }

    public void validateId(String id) {
        if (StringUtils.isBlank(id)) {
            throw new BookValidationException("Id is empty in book request");
        }
        if (!UuidValidator.isValidUUID(id)) {
            throw new BookValidationException("Id " + id + " is not in UUID format in book request");
        }
    }

    public void validateFilter(BookRequest request) {
        if (request == null
                || request.bookFilter() == null
                || BookUtil.isBlank(request.bookFilter())) {
            throw new BookFilterException("There is no any input in the filter");
        }
        validateStringLength(request.bookFilter());
    }

    private void validateStringLength(BookDto book) {
        validateStringLength(book.title(), BookConstant.TITLE);
        validateStringLength(book.creator(), BookConstant.CREATOR);
        validateStringLength(book.tags(), BookConstant.TAGS);
        validateStringLength(book.impressions(), BookConstant.IMPRESSIONS);
    }

    private void validateStringLength(BookFilter filter) {
        validateStringLength(filter.title(), BookConstant.TITLE);
        validateStringLength(filter.creator(), BookConstant.CREATOR);
        validateStringLength(filter.tags(), BookConstant.TAGS);
        validateStringLength(filter.impressions(), BookConstant.IMPRESSIONS);
    }

    private void validateStringLength(String str, String fieldName) {
        if (str != null && str.length() > STRING_LENGTH_MAX) {
            throw new BookValidationException(fieldName + " is longer than " + STRING_LENGTH_MAX + " symbols");
        }
    }

}
