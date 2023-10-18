package com.ironhack.w4d3.controller.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ironhack.w4d3.controller.dto.CourseHoursDTO;
import com.ironhack.w4d3.model.Course;
import com.ironhack.w4d3.model.Teacher;
import com.ironhack.w4d3.repository.CourseRepository;
import com.ironhack.w4d3.repository.TeacherRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class CourseControllerTest {
    @Autowired
    TeacherRepository teacherRepository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    WebApplicationContext webApplicationContext;

    MockMvc mockMvc;

    ObjectMapper objectMapper = new ObjectMapper();

    Course course;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

        Optional<Teacher> teacherOptional = teacherRepository.findById(1);
        assertTrue(teacherOptional.isPresent());
        course = new Course("Politics", 100, "A1", "2 weeks", teacherOptional.get());
    }

    @AfterEach
    public void tearDown() {
        courseRepository.deleteById("Politics");
    }

    @Test
    void getAllCourses_validRequest_allCourses() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/api/courses"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentAsString().contains("Math"));
        assertTrue(mvcResult.getResponse().getContentAsString().contains("Chemistry"));
    }

    @Test
    void getCourseById_validId_correctCourse() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/api/courses/math"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentAsString().contains("math"));
    }

    @Test
    void getCourseById_invalidId_notFound() throws Exception {
        mockMvc.perform(get("/api/courses/potato").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andReturn();
    }

    @Test
    void getCourseByHoursLessThan_100Hours_correctCourses() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/api/courses/hours?hours=100"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentAsString().contains("English"));
    }

    @Test
    void saveCourse_validBody_courseSaved() throws Exception {
        String body = objectMapper.writeValueAsString(course);

        mockMvc.perform(post("/api/courses").content(body).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andReturn();

        assertTrue(courseRepository.findAll().toString().contains("Politics"));
    }

    @Test
    void updateCourse_validBody_courseUpdated() throws Exception {
        course.setClassroom("AAA");

        String body = objectMapper.writeValueAsString(course);

        mockMvc.perform(put("/api/courses/math").content(body).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent())
                .andReturn();

        assertTrue(courseRepository.findAll().toString().contains("AAA"));
    }

    @Test
    void updateCourseHours_validBody_courseUpdated() throws Exception {
        CourseHoursDTO courseHoursDTO = new CourseHoursDTO(333);

        String body = objectMapper.writeValueAsString(courseHoursDTO);

        mockMvc.perform(patch("/api/courses/hours/math").content(body).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent())
                .andReturn();

        assertTrue(courseRepository.findAll().toString().contains("333"));
    }

    @Test
    void deleteCourse_validRequest_courseDeleted() throws Exception {
        courseRepository.save(course);

        mockMvc.perform(delete("/api/courses/politics"))
                .andExpect(status().isNoContent())
                .andReturn();

        assertFalse(courseRepository.findAll().toString().contains("Politics"));
    }
}