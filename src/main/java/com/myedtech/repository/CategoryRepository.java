package com.myedtech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.myedtech.models.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
}