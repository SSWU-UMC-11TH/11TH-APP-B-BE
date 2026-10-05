package com.umc.umc_study.controller;

import com.umc.umc_study.dto.BookResponse;
import com.umc.umc_study.dto.CreateBookRequest;
import com.umc.umc_study.service.BookService;
import jakarta.validation.Valid; // @Valid import 추가
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController // 1. "나는 데이터를 JSON으로 서빙하는 API 카운터야!"
@RequestMapping("/books") // 2. 이 컨트롤러로 들어오는 요청의 기본 주소는 /books
@RequiredArgsConstructor
public class BookController {

    // 주방장(Service)을 주입받아 카운터 옆에 대기시킵니다.
    private final BookService bookService;

    /* 3주차 Map 방식 (현재 주석 처리)
    @GetMapping("/old")
    public List<Map<String, Object>> getBooksOld() {
        return bookService.getAllBooks();
    }

    @PostMapping("/old")
    public String createBookOld(@RequestBody Map<String, Object> body){
        bookService.createBook(body);
        return "도서 등록이 완료되었습니다!";
    }

    @GetMapping("/category/{categoryId}")
    public List<Map<String, Object>> getBooksByCategory(@PathVariable Long categoryId) {
        return bookService.getBooksByCategoryId(categoryId);
    }
    */

    // [실습 1] GET /books (도서 전체 목록 조회)
    @GetMapping
    public List<BookResponse> getBooks() {
        return bookService.getBooks();
    }

    // [실습 2] POST /books (신규 도서 등록)
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookResponse createBook(@Valid @RequestBody CreateBookRequest request) {
        return bookService.createBook(request);
    }
}