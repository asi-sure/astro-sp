package com.congreso.backend.repository;

import com.congreso.backend.model.Person;
import com.congreso.backend.model.Persons;

import java.util.List;

public interface PersonR {
    List<Person> findAll();

    Person getById(Long id);
    Persons getById2(String username);

    Long save(Person person);

    boolean update(Person person, Long id);

    boolean deleteById(Long id);
}
