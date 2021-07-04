package com.example.springJDBC.service;

import com.example.springJDBC.entities.Person;
import com.example.springJDBC.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonServiсe {
    PersonRepository personRepository;

    public Person findByName(String name){
        return personRepository.findByName(name);
    }
    public Person findById(Long id) { return personRepository.findById(id).get();}


    public void add(Person p){
        personRepository.save(p);
    }

    @Autowired
    public PersonServiсe(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
}
