package com.myedtech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.myedtech.models.dto.CourseDto;
import com.myedtech.models.entity.Course;
import com.myedtech.services.CourseService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping("/create")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity create(@RequestBody CourseDto courseDto) {
        try {
            int id = courseService.addCourse(courseDto);
            Map<String, String> result = new HashMap<>();
            result.put("id", String.valueOf(id));
            result.put("msg", "created successfully");

            return new ResponseEntity(result, HttpStatus.CREATED);
        } catch (Exception e) {

        }
        return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public ResponseEntity search(@RequestParam String keyword) {
        try {
            List<CourseDto> dtos = courseService.search(keyword);
            return new ResponseEntity<Object>(dtos, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/get/{courseid}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	public ResponseEntity getCourseById(@PathVariable("courseid") int id)
	{
        try {
            Course course = courseService.getCourseById(id);
            return new ResponseEntity<Object>(course, HttpStatus.OK);
            // CourseDto dto = new CourseDto();
            // dto.setCategoryId(id);
            // CourseDto result = courseService.getCourseByCourseDto(dto);
            //return new ResponseEntity<Object>(result, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		//  List<CourseDto> dtos = courseService.getCourseById(id);
		// return new ResponseEntity<Course>(course,HttpStatus.OK);
	}

    @PostMapping("/update")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity update(@RequestBody CourseDto courseDto) {
        try {
            int id = courseService.updateCourse(courseDto);
            Map<String, String> result = new HashMap<>();
            result.put("id", String.valueOf(id));
            result.put("msg", "updated successfully");

            return new ResponseEntity(result, HttpStatus.OK);
        } catch (Exception e) {

        }
        return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
    }

    @PostMapping("/delete")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity deleteCourse(@RequestBody CourseDto course) {
        try {
            int id = courseService.deleteCourseById(course.getCategoryId());
            Map<String, String> result = new HashMap<>();
            result.put("id", String.valueOf(id));
            result.put("msg", "deleted successfully");

            return new ResponseEntity(result, HttpStatus.OK);
        } catch (Exception e) {

        }
        return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
    }
}