package com.myedtech.services.impl;

import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.stereotype.Service;
import com.myedtech.models.dto.CourseDto;
import com.myedtech.models.dto.SearchDto;
import com.myedtech.models.entity.Course;
import com.myedtech.models.entity.CourseElasticsearch;
import com.myedtech.repository.CourseRepository;
import com.myedtech.services.CourseService;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private ElasticsearchOperations elasticsearchOperations;

    @Override
    public int addCourse(CourseDto courseDto) {
        Course course = new Course();
        course.setId(courseDto.getId());
        course.setTitle(courseDto.getTitle());
        course.setImage(courseDto.getImage());
        course.setHourCount(courseDto.getHourCount());
        course.setViewCount(0);
        course.setPrice(courseDto.getPrice());
        course.setDesc(courseDto.getDescription());
        course.setContent(courseDto.getContent());
        course.setCateId(courseDto.getCategoryId());
        course.setLastUpdate(new Date());

        return courseRepository.saveAndFlush(course).getId();
    }

    @Override
    public int updateCourse(CourseDto courseDto) {
        Course course = courseRepository.findById(courseDto.getId()).get();

        //course.setId(courseDto.getId());
        course.setTitle(courseDto.getTitle());
        course.setImage(courseDto.getImage());
        course.setHourCount(courseDto.getHourCount());
        course.setViewCount(0);
        course.setPrice(courseDto.getPrice());
        course.setDesc(courseDto.getDescription());
        course.setContent(courseDto.getContent());
        course.setCateId(courseDto.getCategoryId());
        course.setLastUpdate(new Date());

        return courseRepository.saveAndFlush(course).getId();
    }

    @Override
    public List<CourseDto> search(String keyword) {

        QueryBuilder queryBuilder = QueryBuilders.matchQuery("title", keyword);

        Query searchQuery = new NativeSearchQueryBuilder()
                .withQuery(queryBuilder)
                .build();

        SearchHits<CourseElasticsearch> courseHits = elasticsearchOperations
                .search(searchQuery, CourseElasticsearch.class, IndexCoordinates.of("course"));

        return courseHits.stream().map(courseHit -> {
            CourseElasticsearch courseElasticsearch = courseHit.getContent();
            CourseDto dto = new CourseDto();
            dto.setTitle(courseElasticsearch.getTitle());
            dto.setDescription(courseElasticsearch.getDescription());
            dto.setPrice(courseElasticsearch.getPrice());
            return dto;
        }).collect(Collectors.toList());
    }

    @Override
    public List<CourseDto> search(SearchDto searchDto) {
        return courseRepository.searchCourse(searchDto);
    }

    @Override
    public Course getCourseById(int id) {
        
        Course course = courseRepository.findById(id).get();
        return course;    
    }

    @Override
    public CourseDto getCourseByCourseDto(CourseDto dto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCourseByCourseDto'");
    }

    @Override
    public int deleteCourseById(int courseId) {
        courseRepository.deleteById(courseId);
        return courseId;
    }

    // @Override
    // public CourseDto getCourseByCourseDto(CourseDto dto) {
    //    return courseRepository.getCourseByCategoryId(dto.getCategoryId());
    // }
}