package com.ironhack.w4d1.controller.interfaces;

import com.ironhack.w4d1.model.Course;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

public interface ICourseController {
    public List<Course> getAllCourses();
    public Course getCourseById(String course);
    public List<Course> getCoursesByHoursLessThan(Integer hours);
    public List<Course> getCourseByHoursAndClassroom(String classroom, Optional<Integer> hours);
}
