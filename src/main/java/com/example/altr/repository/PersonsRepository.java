package com.example.altr.repository;

import com.example.altr.model.Persons;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PersonsRepository extends JpaRepository<Persons, Integer> {

    @Query(value = "SELECT * FROM persons LIMIT 10", nativeQuery = true)
    List<Persons> returnTop10();
}
