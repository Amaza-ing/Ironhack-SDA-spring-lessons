package com.ironhack.w3d2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
//@Table(name = "teacher")  // only necessary if the table and the class do not have the same name
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id") //only necessary if the field and the property do not have the same name
    private Integer id;

    private String teacher;

//    Empty constructor is absolutely necessary for Spring to work properly
    public Teacher() {
    }

    public Teacher(Integer id, String teacher) {
        this.id = id;
        this.teacher = teacher;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", teacher='" + teacher + '\'' +
                '}';
    }
}
