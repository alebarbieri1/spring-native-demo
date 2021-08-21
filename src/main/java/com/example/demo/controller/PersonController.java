package com.example.demo.controller;

import com.example.demo.domain.Person;
import com.example.demo.domain.request.PersonRequest;
import com.example.demo.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("person")
public class PersonController {

    private static final Logger LOG
            = LoggerFactory.getLogger(PersonController.class);

    @Autowired
    private PersonService personService;

    @PostMapping
    public ResponseEntity<Person> create(@RequestBody PersonRequest personRequest){
        return ResponseEntity.ok(personService.create(personRequest));
    }
}