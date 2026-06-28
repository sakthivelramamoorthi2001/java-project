package com.example.CRUD.Respository;

import com.example.CRUD.Model.Fees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeesRepo extends JpaRepository<Fees,Integer> {
}
