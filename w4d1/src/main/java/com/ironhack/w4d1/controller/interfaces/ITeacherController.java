package com.ironhack.w4d1.controller.interfaces;

import com.ironhack.w4d1.model.Teacher;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface ITeacherController {
    public List<Teacher> getAllTeachers();
    public Teacher getTeacherById(Integer id);
}
