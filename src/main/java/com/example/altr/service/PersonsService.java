package com.example.altr.service;

import com.example.altr.exceptions.ToughLuckException;
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

    private Random rand = new Random();


    public void setsSeed(int x) {
        rand.setSeed(x);
    }

    public List<Persons> listPersons() throws ToughLuckException {
        int n = rand.nextInt(100);
        if (n%4==0) {
            throw new ToughLuckException();
        } else {
            return repo.returnTop10();
        }
    }
}
