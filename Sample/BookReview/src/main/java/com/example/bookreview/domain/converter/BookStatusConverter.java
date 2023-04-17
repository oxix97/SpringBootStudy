package com.example.bookreview.domain.converter;

import com.example.bookreview.domain.repository.dto.BookStatus;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

// Bookstatus를 엔티티 필드에 사용되어 있으면 사용됩니다.
// 개발자가 직접 만든 컬럼만 사용해야 한다 그렇지 않으면 int, String이런거에 활용하면 메모리 누수가 심해진다.
// 필요한 경우 해당 필드에 @Convert를 사용하는 것을 권장한다.†
@Converter(autoApply = true)
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
