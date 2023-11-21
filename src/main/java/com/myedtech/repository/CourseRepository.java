package com.myedtech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.myedtech.models.dto.CourseDto;
import com.myedtech.models.entity.Course;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer>, CourseRepositoryCustom {

    @Query("SELECT new com.myedtech.models.dto.CourseDto( "
            + "c.id, c.title, c.image, c.hourCount, c.viewCount, c.price, "
            + "c.desc, c.content, c.cateId, c.lastUpdate, ca.name) "
            + "FROM Course c "
            + "JOIN Category ca ON c.cateId = ca.id "
            + "WHERE (c.title LIKE :key "
            + "OR c.content LIKE :key "
            + ") "
            + "ORDER BY c.viewCount")
    List<CourseDto> search(@Param("key") String key);

    // @Query("SELECT * FROM Course c WHERE c.cateId LIKE :categoryId")
    // Course getCourseByCategoryId(@Param("categoryId") int categoryId);
}
