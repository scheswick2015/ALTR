package com.example.altr;

import com.example.altr.model.Persons;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class AltrApplicationTest {

    @Test
    void personsCreated() throws Exception {
        Persons persons = new Persons(1,"John","Smith");
        Assertions.assertNotNull(persons);
    }



}
