package com.ironhack.w4d1.repository;

import com.ironhack.w4d1.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository                              //JpaRepository<Entity, entity primary key data type>
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
}
