package com.congreso.backend.service.Impl;

import com.congreso.backend.model.Person;
import com.congreso.backend.repository.PersonR;
import com.congreso.backend.service.PersonS;
import com.congreso.backend.utils.ApiResponse;
import com.congreso.backend.utils.CustomResponseBuilder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Slf4j
@RequiredArgsConstructor
@Service
public class PersonImplS implements PersonS {
    private final PersonR personR;
    private final CustomResponseBuilder customResponseBuilder;

    @Override
    public ResponseEntity<ApiResponse> findAll() {
        List<Person> persons = personR.findAll();
        return customResponseBuilder.buildResponse(HttpStatus.OK.value(), "Consulta exitosa.", persons);
    }

    @Override
    public ResponseEntity<ApiResponse> getById(Long id) {
        Person person = personR.getById(id);
        return customResponseBuilder.buildResponse(HttpStatus.OK.value(), "Consulta exitosa.", person);
    }

    @Override
    public Person getById2(Long id) {
        return personR.getById(id);
    }

    @Override
    public ResponseEntity<ApiResponse> save(Person person) {
        Long isCreated = personR.save(person);
        return customResponseBuilder.buildResponse(HttpStatus.OK.value(), "Consulta exitosa.", isCreated);
    }

    @Override
    public ResponseEntity<ApiResponse> update(Person person, Long id) {
        personR.update(person, id);
        return customResponseBuilder.buildResponse(HttpStatus.OK.value(), "Consulta exitosa.");
    }

    @Override
    public ResponseEntity<ApiResponse> deleteById(Long id) {
        personR.deleteById(id);
        return customResponseBuilder.buildResponse(HttpStatus.OK.value(), "Consulta exitosa.");
    }
}
