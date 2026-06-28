package com.example.CRUD.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class StudentModel {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;


    @OneToMany
    @JoinColumn(name = "fees_id")
    private List<Fees> feesList;
}

