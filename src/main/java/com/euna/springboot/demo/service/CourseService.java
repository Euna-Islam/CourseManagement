package com.euna.springboot.demo.service;

import com.euna.springboot.demo.model.Course;
import java.math.BigInteger;
import java.util.List;


public interface CourseService {
    Course createCourse(Course course);

    Course fetchCourseById(BigInteger id);

    List<Course> fetchAllCourses();

    void deleteCourseById(BigInteger id);
}
