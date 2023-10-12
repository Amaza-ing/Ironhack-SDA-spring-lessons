package com.ironhack.w3d4.model;

import jakarta.persistence.*;

import java.util.List;


@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String teacher;
    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

//    Use only if we want a bidirectional relationship
//    If used, we must be careful not to create a stackOverflow Error (infinite loop)
//    @OneToMany(mappedBy = "teacher")
//    List<Course> courses;


    public Teacher() {
    }

    public Teacher(String teacher, Address address) {
        this.teacher = teacher;
        this.address = address;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

//    public List<Course> getCourses() {
//        return courses;
//    }
//
//    public void setCourses(List<Course> courses) {
//        this.courses = courses;
//    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", teacher='" + teacher + '\'' +
                ", address=" + address +
                '}';
    }
}
