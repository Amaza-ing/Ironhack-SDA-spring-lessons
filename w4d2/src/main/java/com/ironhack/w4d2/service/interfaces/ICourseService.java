package com.ironhack.w4d2.service.interfaces;

import com.ironhack.w4d2.model.Course;

import java.util.List;
import java.util.Optional;

public interface ICourseService {
    public Course getCourseById(String course);

    public List<Course> getCourseByHoursAndClassroom(String classroom, Optional<Integer> hours);
}
