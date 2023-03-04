package com.example.bookreview.domain.converter;

import com.example.bookreview.domain.repository.dto.BookStatus;
import jakarta.persistence.AttributeConverter;

public class BookStatusConverter implements AttributeConverter<BookStatus, Integer> {
    @Override
    public Integer convertToDatabaseColumn(BookStatus attribute) {
        return attribute.getCode();
    }

    @Override
    public BookStatus convertToEntityAttribute(Integer dbData) {
        return dbData != null ? new BookStatus(dbData) : null;
    }
}
