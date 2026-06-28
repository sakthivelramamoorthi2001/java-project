package com.example.CRUD.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Course {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String course;

    @OneToMany(mappedBy = "course")
    private List<Subject> subjects;

}
