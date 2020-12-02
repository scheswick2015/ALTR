package com.example.altr;

import com.example.altr.exceptions.ToughLuckException;
import com.example.altr.model.Persons;
import com.example.altr.repository.PersonsRepository;
import com.example.altr.service.PersonsService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.List;


@SpringBootTest
public class AltrApplicationTest {

    @Autowired
    PersonsService service;
    @Autowired
    PersonsRepository repo;

    @Test
    void createPersonsObjectTest() throws Exception {
        Persons persons = new Persons(1,"John","Smith");
        Assertions.assertNotNull(persons);
    }

    @Test
    void createServiceObjectTest() throws Exception {
        Assertions.assertNotNull(service);
    }

    @Test
    void createRepoObjectTest() throws Exception {
        Assertions.assertNotNull(repo);
    }

    @Test
    void queryCorrectNumberofValuesTest() throws Exception {
        //Test ensuring the MYSQL query is returning the expected 10 results
        List<Persons> queryVal = repo.returnTop10();
        Assertions.assertEquals(10, queryVal.size());

    }

    @Test
    void validateListPersonsTest() throws Exception {
        //Tests to see that if for a set seed the listPersons() method returns the expected values from the SQL table
        service.setsSeed(1);
        String expected = "[1 Steven Cheswick, 2 Steven Cheswick, 3 Steven Cheswick, " +
                "4 Steven Cheswick, 5 Steven Cheswick, 6 Steven Cheswick, 7 Steven Cheswick," +
                " 8 Steven Cheswick, 9 Steven Cheswick, 10 Steven Cheswick]";

        Assertions.assertEquals(expected, service.listPersons().toString());
    }

    @Test
    void passFailPercentageRangeTest() throws Exception {
        /*Tests to see if the programs random number generator is producing successful responses
          At 75% with a range of +- 5% and Unsuccessful responses at 25% with a range of +- 5%.
         */
        service.setsSeed(1);
        int pass = 0;
        int fail = 0;
        for (int i = 0; i < 1000; i++) {
            try {
                service.listPersons();
                pass++;
            }
            catch (ToughLuckException e){
                fail++;
            }
        }
        Assertions.assertTrue(700 <= pass && pass <= 800);
        Assertions.assertTrue(200 <= fail && fail <= 300);
    }

    @Test
    void serviceToughLuckExceptionTest() throws Exception {
        /*Using a preset seed that is known to produce a random number that fails
          on the first random.nextInt() to test that the ToughLuckException is operating
          as intended
         */
        try {
            service.setsSeed(2);
            service.listPersons();
            assert false;
        }
        catch (ToughLuckException e){
            assert true;
        }
    }
}
