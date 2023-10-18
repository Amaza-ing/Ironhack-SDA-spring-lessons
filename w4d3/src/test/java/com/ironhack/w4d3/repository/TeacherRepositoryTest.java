package com.ironhack.w4d3.repository;

import com.ironhack.w4d3.model.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {
    @Autowired
    TeacherRepository teacherRepository;

    @Test
    public void findAll_teachers_teacherList() {
        List<Teacher> teacherList = teacherRepository.findAll();
        System.out.println(teacherList);
        assertEquals(3, teacherList.size());
    }

    @Test
    public void findById_validId_correctTeacher() {
        Optional<Teacher> teacherOptional = teacherRepository.findById(1);
        assertTrue(teacherOptional.isPresent());
        System.out.println(teacherOptional.get());
        assertEquals("Alberto García", teacherOptional.get().getTeacher());
    }

    @Test
    public void findById_invalidId_teacherNotPresent() {
        Optional<Teacher> teacherOptional = teacherRepository.findById(999);
        assertTrue(teacherOptional.isEmpty());
    }
}