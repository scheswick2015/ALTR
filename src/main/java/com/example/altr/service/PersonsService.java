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

    /**
     *
     * @param seed
     */
    public void setsSeed(int seed) {
        rand.setSeed(seed);
    }

    /**
     *
     * @return Returns the top 10 results from a mysql database 75% of the time
     * @throws ToughLuckException throws "Tough Luck" 25% of the time
     */
    public List<Persons> listPersons() throws ToughLuckException {
        //Random number generator is used with a % 4 to return a failed result 25% of the time
        int n = rand.nextInt(100);
        if (n%4==0) {
            throw new ToughLuckException();
        } else {
            return repo.returnTop10();
        }
    }
}
