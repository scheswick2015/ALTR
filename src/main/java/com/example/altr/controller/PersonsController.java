package com.example.altr.controller;

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

    @GetMapping("/persons")
    public ResponseEntity<List<Persons>> list() {
        try {
            List<Persons> persons = service.listPersons();
            return new ResponseEntity<List<Persons>>(persons, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<List<Persons>>(HttpStatus.NOT_FOUND);
        }

    }
}
