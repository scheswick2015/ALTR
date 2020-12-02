package com.example.altr.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Persons {
    private Integer id;
    private String FirstName;
    private String LastName;

    public Persons() {

    }

    /**
     *
     * @param id auto-incrementing primary key to identify a person
     * @param firstName first name that is 60 chars or less when stored in db
     * @param lastName last name that is 60 chars or less when stored in db
     */
    public Persons(Integer id, String firstName, String lastName) {
        this.id = id;
        FirstName = firstName;
        LastName = lastName;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    @Override
    public String toString() {
        return String.format(id  +" " +  FirstName + " " + LastName);
    }
}
