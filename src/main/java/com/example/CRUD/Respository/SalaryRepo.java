package com.example.CRUD.Respository;

import com.example.CRUD.Model.Salary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaryRepo extends JpaRepository<Salary,Integer> {
}
