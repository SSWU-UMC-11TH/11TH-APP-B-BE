package com.umc.umc_study.repository;

import com.umc.umc_study.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}