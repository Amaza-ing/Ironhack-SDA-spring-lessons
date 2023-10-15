package com.ironhack.w3d5.repository;

import com.ironhack.w3d5.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository                              //JpaRepository<Entity, entity primary key data type>
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
}
