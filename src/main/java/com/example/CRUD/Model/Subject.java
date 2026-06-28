package com.example.CRUD.Model;

import jakarta.persistence.*;

import java.util.stream.Collector;

@Entity
public class Subject {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String subject;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
}
