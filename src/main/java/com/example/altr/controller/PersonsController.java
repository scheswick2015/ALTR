package com.example.altr.controller;

import com.example.altr.exceptions.ToughLuckException;
import com.example.altr.model.Persons;
import com.example.altr.service.PersonsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.NoSuchElementException;


@RestController
public class PersonsController {

    @Autowired
    private PersonsService service;

    /**
     *
     * @return ResponseEntity represents the whole HTTP response: status code, headers, and body.
     * As a result, we can use it to fully configure the HTTP response.
     */
    @GetMapping("/persons")
    public ResponseEntity<?> list() {
        try {
            List<Persons> persons = service.listPersons();
            return new ResponseEntity<List<Persons>>(persons, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<List<Persons>>(HttpStatus.NOT_FOUND);
        } catch (ToughLuckException e) {
            return new ResponseEntity<>("Tough Luck", HttpStatus.BAD_REQUEST);
        }
    }
}
