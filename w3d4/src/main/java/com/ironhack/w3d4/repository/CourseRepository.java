package com.ironhack.w3d4.repository;

import com.ironhack.w3d4.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course, String> {

//    JPA QUERY KEYWORDS

    Optional<Course> findByHours(Integer hours);
    List<Course> findAllByClassroom(String classroom);
    List<Course> findAllByCourseContaining(String str);
    List<Course> findAllByHoursLessThan(Integer hours);


//    JPQL

    @Query("SELECT c FROM Course c WHERE c.hours = 150")
    List<Course> findAllWhereHours150();

    @Query("SELECT SUM(c.hours) FROM Course c")
    Integer findSumHours();

    @Query("SELECT c FROM Course c WHERE c.classroom = ?1 AND c.hours <= ?2")
    List<Course> findAllWhereClassroomAndHoursParams(String classroom, Integer hours);

    @Query("SELECT c FROM Course c WHERE c.classroom = :classroomParam AND c.hours <= :hoursParam")
    List<Course> findAllWhereClassroomAndHoursNamedParams(
            @Param("classroomParam") String classroom,
            @Param("hoursParam") Integer hours
    );


//    NATIVE SQL

    @Query(value = "SELECT * FROM course c WHERE c.hours = 150", nativeQuery = true)
    List<Course> nativeFindAllWhereHours150();

    @Query(value = "SELECT SUM(c.hours) FROM course c", nativeQuery = true)
    Integer nativeFindSumHours();

    @Query(value = "SELECT * FROM course c WHERE c.classroom = ?1 AND c.hours <= ?2", nativeQuery = true)
    List<Course> nativeFindAllWhereClassroomAndHoursParams(String classroom, Integer hours);

    @Query(value = "SELECT * FROM course c WHERE c.classroom = :classroomParam AND c.hours <= :hoursParam", nativeQuery = true)
    List<Course> nativeFindAllWhereClassroomAndHoursNamedParams(
            @Param("classroomParam") String classroom,
            @Param("hoursParam") Integer hours
    );

}
