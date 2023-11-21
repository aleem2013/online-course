package com.myedtech.services;

import com.myedtech.models.dto.CourseDto;
import com.myedtech.models.dto.SearchDto;
import com.myedtech.models.entity.Course;

import java.util.List;

public interface CourseService {

    int addCourse(CourseDto courseDto);

    List<CourseDto> search(String keyword);

    List<CourseDto> search(SearchDto searchDto);

    Course getCourseById(int id);

    CourseDto getCourseByCourseDto(CourseDto dto);

    int updateCourse(CourseDto courseDto);

    int deleteCourseById(int courseId);
}