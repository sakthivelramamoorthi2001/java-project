package com.example.CRUD.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Faculty {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id = null;
    String name;

    @OneToMany(mappedBy = "faculty",  cascade = CascadeType.ALL)
    @Column(nullable = false)
    @JsonManagedReference
    private List<Salary> salaryList;

}
