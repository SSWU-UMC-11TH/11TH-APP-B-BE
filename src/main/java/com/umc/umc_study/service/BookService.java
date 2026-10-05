package com.umc.umc_study.service;

import com.umc.umc_study.dto.BookResponse;
import com.umc.umc_study.dto.CreateBookRequest;
import com.umc.umc_study.entity.Book;
import com.umc.umc_study.entity.Category;
import com.umc.umc_study.repository.BookRepository;
import com.umc.umc_study.repository.CategoryRepository; // CategoryRepository 추가
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional; // readOnly 지원을 위해 Spring 패키지로 변경

import java.util.List;
import java.util.Map;

@Service // 비즈니스 로직을 수행하는 메인 셰프 계층
@RequiredArgsConstructor
public class BookService {

    // 창고지기(Repository)를 생성자 주입으로 데려옵니다.
    private final BookRepository bookRepository;
    private final CategoryRepository categoryRepository; // categoryRepository 선언 추가

    /* 3주차 Raw SQL/Map 방식 (현재 주석 처리)
    public List<Map<String, Object>> getAllBooks() {
        // 지금은 별도 가공 없이 창고지기가 가져온 도서 목록을 그대로 반환합니다.
        return bookRepository.findAll();
    }

    public void createBook(Map<String, Object> body){
        bookRepository.save(body);
    }

    public List<Map<String, Object>> getBooksByCategoryId(Long categoryId) {
        return bookRepository.findByCategoryId(categoryId);
    }
    */

    // [실습 1] 도서 전체 목록 조회
    @Transactional(readOnly = true)
    public List<BookResponse> getBooks() {
        return bookRepository.findAllByOrderByBookIdDesc().stream()
                .map(BookResponse::from)
                .toList();
    }

    // [실습 2] 신규 도서 등록
    @Transactional
    public BookResponse createBook(CreateBookRequest request) {
        Category category = categoryRepository.findById(request.categoryId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 카테고리입니다."));

        Book book = new Book(category, request.title(), request.description());
        return BookResponse.from(bookRepository.save(book));
    }

}