package com.example.altr;

import com.example.altr.exceptions.ToughLuckException;
import com.example.altr.model.Persons;
import com.example.altr.repository.PersonsRepository;
import com.example.altr.service.PersonsService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@SpringBootTest
public class AltrApplicationTest {

    PersonsService service = new PersonsService();


    @Test
    void personsCreated() throws Exception {
        Persons persons = new Persons(1,"John","Smith");
        Assertions.assertNotNull(persons);
    }

    @Test
    void serviceException() throws Exception {
        try{
        service.setsSeed(2);
        service.listPersons();
        assert false;}
        catch (ToughLuckException e){
            assert true;
        }
    }







}
