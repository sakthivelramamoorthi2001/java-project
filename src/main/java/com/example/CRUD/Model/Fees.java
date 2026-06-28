package com.example.CRUD.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
public class Fees {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String fees;
    @Column(nullable = false)
    double amount = 10;


    @ManyToOne
    @JoinColumn(name = "studentModel")
    private StudentModel studentModel;
}
