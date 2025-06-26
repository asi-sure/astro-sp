package com.congreso.backend.repository;

import com.congreso.backend.model.Departament;
import com.congreso.backend.model.Person;
import com.congreso.backend.model.Persons;

import java.util.List;

public interface PersonsR {

    List<Persons> findAll(boolean xstatus);

    Persons findById(int id);
    Long savePersons(Persons person);
    boolean update(Persons obj, int id);

    boolean verificarCedula(String xcedula, int id);

}
