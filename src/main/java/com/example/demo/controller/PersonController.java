package com.example.demo.controller;

import com.example.demo.domain.Person;
import com.example.demo.domain.request.PersonRequest;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping
    public ResponseEntity<Person> create(@RequestBody PersonRequest personRequest){
        return ResponseEntity.ok(personService.create(personRequest));
    }
}