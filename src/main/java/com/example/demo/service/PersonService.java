package com.example.demo.service;

import com.example.demo.domain.Person;
import com.example.demo.domain.request.PersonRequest;
import com.example.demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public Person create(PersonRequest personRequest){
        Person person = new Person();
        person.setAge(personRequest.getAge());
        person.setName(personRequest.getName());

        return personRepository.save(person);
    }
}