package com.example.demo;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersonConfig {
    @Autowired
    private PersonRepository repository;

    @PostConstruct
    public void setup() {
        repository.save(new Person(null, null, null));
        repository.save(new Person(2L, "Leon", "Hunter"));
        repository.save(new Person(123890L, "Noel", "Retnuh"));
    }
}

