package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    @Autowired
    private PersonRepository repository;


    public Person create(Person person) {
        return repository.save(person);
    }

    public Person read(Long id) {
        Optional<Person> personOptional = repository.findById(id);
        Person actualPerson = personOptional.get();
        return actualPerson;
    }

    public List<Person> readAll() {
        final Iterable<Person> iterable = repository.findAll();
        final List<Person> result = new ArrayList<>();
        iterable.forEach(result::add);
        return result;
    }

    public Person update(Long id, Person newData) {
        final Person oldPersonInDatabase = read(id);
        oldPersonInDatabase.setId(newData.getId());
        oldPersonInDatabase.setFirstname(newData.getFirstname());
        oldPersonInDatabase.setLastname(newData.getLastname());
        final Person newPersonInDatabase = repository.save(oldPersonInDatabase);
        return newPersonInDatabase;
    }

    public Person delete(Long id) {
        final Person personInDatabase = read(id);
        repository.delete(personInDatabase);
        return personInDatabase;
    }


}
