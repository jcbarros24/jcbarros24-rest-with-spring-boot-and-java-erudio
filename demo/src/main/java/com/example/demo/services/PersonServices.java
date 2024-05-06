package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;
import org.springframework.stereotype.Service;

import com.example.demo.model.Person;

@Service
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();  
    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    public List<Person> findAll(){

        logger.info("Finding all people");
        List<Person> personsList = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            Person person = mockPerson(i);
            personsList.add(person);
        }

        return personsList;
    }

    public Person findById(String id){

        logger.info("Finding one person");

        Person person = new Person();
        
        person.setId(counter.incrementAndGet());
        person.setFirstName("José Carlos");
        person.setLastName("Filho");
        person.setAdress("Recife");
        person.setGender("Male");
        return person;
    }

    private Person mockPerson(int i) {
        // TODO Auto-generated method stub
        Person person = new Person();
        
        person.setId(counter.incrementAndGet());
        person.setFirstName("Person name: " + i);
        person.setLastName("Last name: " + i);
        person.setAdress("Adress: " + i);
        person.setGender("Male");
        return person;    }
}