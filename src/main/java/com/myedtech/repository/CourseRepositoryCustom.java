package com.myedtech.repository;

import com.myedtech.models.dto.CourseDto;
import com.myedtech.models.dto.SearchDto;

import java.util.List;

public interface CourseRepositoryCustom {

    List<CourseDto> searchCourse(SearchDto dto);
}