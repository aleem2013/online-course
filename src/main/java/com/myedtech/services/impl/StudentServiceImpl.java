package com.myedtech.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.stereotype.Service;
import com.myedtech.models.dto.SelectedCourseDto;
import com.myedtech.models.dto.StudentDto;
import com.myedtech.models.entity.Course;
import com.myedtech.models.entity.Student;
import com.myedtech.models.entity.UserCourse;
import com.myedtech.repository.CourseRepository;
import com.myedtech.repository.StudentRepository;
import com.myedtech.services.StudentService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ElasticsearchOperations elasticsearchOperations;

    @Override
    public int registerStudent(StudentDto studentDto) {
        Student student = new Student();
        student.setId(studentDto.getId());
        student.setNameInEnglish(studentDto.getNameInEnglish());
        student.setNameInArabic(student.getNameInArabic());
        student.setEmail(studentDto.getEmail());
        student.setTelephone(studentDto.getTelephone());
        student.setAddress(studentDto.getAddress());
        // List<UserCourse> userCourses = new ArrayList<UserCourse>();

        // Student student1 = studentRepository.getById(studentDto.getId());
        // Course course = new Course();
        // List<SelectedCourseDto> selectedCourses = studentDto.getSelectedCourses();

        // for (SelectedCourseDto selectedCourse : selectedCourses) {
        //     course.setCateId(selectedCourse.getCourseId());
        //     course.setId(selectedCourse.getCourseId());
        //     course.setTitle(selectedCourse.getCourseName());
        // }
        
        

        // UserCourse userCourse = new UserCourse(student1, course);
        // userCourses.add(userCourse);
        // student.setSelectedCourses(userCourses);
        student.setLastUpdate(new Date());

        return studentRepository.saveAndFlush(student).getId();
    }

    @Override
    public int updateCourseForStudent(StudentDto studentDto) {
        Student student = studentRepository.findById(studentDto.getId()).get();

        //student.setId(studentDto.getId());
        List<UserCourse> userCourses = new ArrayList<UserCourse>();

        Student student1 = studentRepository.getById(studentDto.getId());
        Course course = new Course();
        List<SelectedCourseDto> selectedCourses = studentDto.getSelectedCourses();

        for (SelectedCourseDto selectedCourse : selectedCourses) {
            course.setCateId(selectedCourse.getCourseId());
            course.setId(selectedCourse.getCourseId());
            course.setTitle(selectedCourse.getCourseName());
        }
        
        

        UserCourse userCourse = new UserCourse(student1, course);
        userCourses.add(userCourse);
        student.setSelectedCourses(userCourses);
        student.setLastUpdate(new Date());

        return studentRepository.saveAndFlush(student).getId();
    }


    @Override
    public int deleteStudentById(int studentId) {
        studentRepository.deleteById(studentId);
        return studentId;
    }

    @Override
    public List<Student> getAllStudentsWithCourses() {
        return studentRepository.findAll();
    }

    // @Override
    // public CourseDto getCourseByCourseDto(CourseDto dto) {
    //    return courseRepository.getCourseByCategoryId(dto.getCategoryId());
    // }
}