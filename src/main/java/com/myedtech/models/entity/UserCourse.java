package com.myedtech.models.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_courses")
public class UserCourse {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private UserCourseKey id;

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private Student user;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "course_id", insertable = false, updatable = false)
    private Course course;

    public UserCourse() {

    }

    

    public UserCourse(Student user, Course course) {
        this.user = user;
        this.course = course;
    }



    public UserCourse(UserCourseKey id) {
        this.id = id;
    }

    public UserCourseKey getId() {
        return id;
    }

    public void setId(UserCourseKey id) {
        this.id = id;
    }

    public Student getUser() {
        return user;
    }

    public void setUser(Student user) {
        this.user = user;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

}