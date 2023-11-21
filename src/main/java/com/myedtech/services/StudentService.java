package com.myedtech.services;

import java.util.List;

import com.myedtech.models.dto.StudentDto;
import com.myedtech.models.entity.Student;

public interface StudentService {

    int registerStudent(StudentDto courseDto);

    List<Student> getAllStudentsWithCourses();

    // Course getCourseById(int id);

    // CourseDto getCourseByCourseDto(CourseDto dto);

    int updateCourseForStudent(StudentDto studentDto);

    int deleteStudentById(int studentId);
}