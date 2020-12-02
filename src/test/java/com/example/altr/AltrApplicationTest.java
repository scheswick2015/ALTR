package com.example.altr;

import com.example.altr.model.Persons;
import com.example.altr.service.PersonsService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;


class AltrApplicationTest {

    PersonsService service = new PersonsService();


    @Test
    void personsCreated() throws Exception {
        Persons persons = new Persons(1,"John","Smith");
        Assertions.assertNotNull(persons);
    }

    @Test
    void serviceException() throws Exception {
        service.setsSeed(2);
        service.listPersons();
    }







}
