package com.example.altr.service;

import com.example.altr.model.Persons;
import com.example.altr.repository.PersonsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class PersonsService {
    @Autowired
    private PersonsRepository repo;

    public List<Persons> listPersons() {
        Random rand = new Random();
        int n = rand.nextInt(100);
        if (n%4==0) {
            return repo.returnTop0();
        } else {
            return repo.returnTop10();
        }
    }
}
