package com.euna.springboot.demo.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import com.euna.springboot.demo.model.Course;
import com.euna.springboot.demo.service.CourseService;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@ExtendWith(SpringExtension.class)
@WebMvcTest(CourseController.class)
public class CourseControllerTest {
    @MockBean
    CourseService courseService;

    @Autowired
    MockMvc mockMvc;

    @Test
    public void test_index() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk());
    }

    @Test
    public void test_returnAllCourses() throws Exception {
        List<Course> allCourses = new ArrayList<>();

        Course course = new Course();
        course.setCourseid(new BigInteger("1"));
        course.setCoursename("TestCourse");
        course.setAuthor("Angel");
        allCourses.add(course);

        Mockito.when(courseService.fetchAllCourses()).thenReturn(allCourses);

        mockMvc.perform(get("/fetchAllCourses"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].coursename", Matchers.is("TestCourse")));
    }

    @Test
    public void test_returnCourseById() throws Exception {
        Course course = new Course();
        course.setCourseid(new BigInteger("1"));
        course.setCoursename("TestCourse");
        course.setAuthor("Angel");

        Mockito.when(courseService.fetchCourseById(new BigInteger("1"))).thenReturn(course);

        mockMvc.perform(get("/fetchCourseById/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.coursename", Matchers.is("TestCourse")));
    }

    @Test
    public void test_deleteCourseById() throws Exception {
           mockMvc.perform(MockMvcRequestBuilders.delete("/deleteCourse/1"))
                .andExpect(status().isOk());
    }



}
