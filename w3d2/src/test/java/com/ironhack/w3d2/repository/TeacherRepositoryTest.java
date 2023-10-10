package com.ironhack.w3d2.repository;

import com.ironhack.w3d2.model.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

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
}