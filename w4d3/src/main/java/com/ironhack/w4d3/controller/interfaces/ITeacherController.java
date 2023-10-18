package com.ironhack.w4d3.controller.interfaces;

import com.ironhack.w4d3.model.Teacher;

import java.util.List;

public interface ITeacherController {
    public List<Teacher> getAllTeachers();
    public Teacher getTeacherById(Integer id);
}
