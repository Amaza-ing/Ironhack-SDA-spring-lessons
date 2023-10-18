package com.ironhack.w4d3.service.interfaces;

import com.ironhack.w4d3.model.Course;

import java.util.List;
import java.util.Optional;

public interface ICourseService {
    public Course getCourseById(String course);

    public List<Course> getCourseByHoursAndClassroom(String classroom, Optional<Integer> hours);

    void updateCourse(Course course, String id);

    void updateCourseHours(Integer hours, String id);

    void updateCourseClassroom(String classroom, String id);

    void deleteCourse(String id);
}
