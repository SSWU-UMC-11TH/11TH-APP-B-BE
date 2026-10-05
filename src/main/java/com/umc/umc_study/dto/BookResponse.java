package com.umc.umc_study.dto;

import com.umc.umc_study.entity.Book;

public record BookResponse(
        Long bookId,
        String title,
        String description,
        String categoryName,
        Boolean isAvailable
) {
    public static BookResponse from(Book book) {
        return new BookResponse(
                book.getBookId(),
                book.getTitle(),
                book.getDescription(),
                book.getCategory().getName(), // Category 엔티티의 이름 필드
                book.getIsAvailable()
        );
    }
}