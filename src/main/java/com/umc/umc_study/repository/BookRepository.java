package com.umc.umc_study.repository;

import com.umc.umc_study.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    // [실습 1] 최신 등록순(bookId 내림차순) 조회 메서드
    List<Book> findAllByOrderByBookIdDesc();

    /* 3주차 JdbcTemplate / Raw SQL 방식 (현재 주석 처리)

    // private final JdbcTemplate jdbcTemplate;

    public List<Map<String, Object>> findAll() {
        String sql = "SELECT * FROM book";
        return jdbcTemplate.queryForList(sql);
    }

    public void save(Map<String, Object> body){
        String sql = "INSERT INTO book (category_id, title, description, is_available) VALUES (?, ?, ?, true)";
        jdbcTemplate.update(
                sql,
                body.get("categoryId"),
                body.get("title"),
                body.get("description")
        );
    }

    public List<Map<String, Object>> findByCategoryId(Long categoryId) {
        String sql = "SELECT book_id, category_id, title, description, is_available " +
                "FROM book WHERE category_id = ?";
        return jdbcTemplate.queryForList(sql, categoryId);
    }
    */
}