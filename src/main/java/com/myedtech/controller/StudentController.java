package com.myedtech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.myedtech.models.dto.StudentDto;
import com.myedtech.models.entity.Student;
import com.myedtech.services.CourseService;
import com.myedtech.services.StudentService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/student")
public class StudentController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private StudentService studentService;

    @PostMapping("/register")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public ResponseEntity register(@RequestBody StudentDto studentDto) {
        try {
            int id = studentService.registerStudent(studentDto);
            Map<String, String> result = new HashMap<>();
            result.put("id", String.valueOf(id));
            result.put("msg", "Student registerd successfully");

            return new ResponseEntity<>(result, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
        }        
    }

    @GetMapping("/get/all")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	public ResponseEntity getAllStudentsWithCourses()
	{
        try {
            List<Student> students = studentService.getAllStudentsWithCourses();
            return new ResponseEntity<Object>(students, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
	}

    // @GetMapping("/get/{courseid}")
    // @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	// public ResponseEntity getCourseById(@PathVariable("courseid") int id)
	// {
    //     try {
    //         Course course = courseService.getCourseById(id);
    //         return new ResponseEntity<Object>(course, HttpStatus.OK);
    //         // CourseDto dto = new CourseDto();
    //         // dto.setCategoryId(id);
    //         // CourseDto result = courseService.getCourseByCourseDto(dto);
    //         //return new ResponseEntity<Object>(result, HttpStatus.OK);
    //     } catch (Exception e) {
    //         System.out.println(e.getMessage());
    //     }
    //     return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	// 	//  List<CourseDto> dtos = courseService.getCourseById(id);
	// 	// return new ResponseEntity<Course>(course,HttpStatus.OK);
	// }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity deleteStudent(@PathVariable int id) {
        try {
            studentService.deleteStudentById(id);
            Map<String, String> result = new HashMap<>();
            result.put("id", String.valueOf(id));
            result.put("msg", "Student record deleted successfully");

            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
        }        
    }

    @PostMapping("/update")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity updateCourseForStudent(@RequestBody StudentDto studentDto) {
        try {
            int id = studentService.updateCourseForStudent(studentDto);
            Map<String, String> result = new HashMap<>();
            result.put("id", String.valueOf(id));
            result.put("msg", "Student course details updated successfully");

            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
        }        
    }
}