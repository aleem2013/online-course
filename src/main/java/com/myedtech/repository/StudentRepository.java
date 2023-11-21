package com.myedtech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.myedtech.models.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    // @Query("SELECT * FROM Course c WHERE c.cateId LIKE :categoryId")
    // Course getCourseByCategoryId(@Param("categoryId") int categoryId);
}
