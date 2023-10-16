package com.ironhack.w4d1.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
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


    public Teacher(String teacher, Address address) {
        this.teacher = teacher;
        this.address = address;
    }
}
