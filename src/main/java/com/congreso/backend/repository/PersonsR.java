package com.congreso.backend.repository;

import com.congreso.backend.enumeration.Tipo_persons;
import com.congreso.backend.model.Departament;
import com.congreso.backend.model.Person;
import com.congreso.backend.model.Persons;
import com.congreso.backend.model.Role;
import com.congreso.backend.model.dto.PersonsDto;

import java.util.List;

public interface PersonsR {

    List<PersonsDto> findAll(boolean xstatus, Tipo_persons tipoper);

    Persons findById(int id);
    List<Role> roleFindById(int id);
    Long savePersons(Persons person);
    boolean update(Persons obj, int id);
    boolean update_foto(String foto, int id);
    boolean updateTipoper(Tipo_persons tipoper, int id);
    boolean delete(int id);
    boolean verificarCedula(String xcedula, int id);

}
