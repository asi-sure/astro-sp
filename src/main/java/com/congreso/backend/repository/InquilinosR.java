package com.congreso.backend.repository;

import com.congreso.backend.model.Persons;
import com.congreso.backend.model.dto.PersonsDto;
import com.congreso.backend.model.forms.InquilinosForm;

import java.util.List;

public interface InquilinosR {

    List<InquilinosForm> findAll(boolean xestado);
    Long save(InquilinosForm obj);
    boolean update(InquilinosForm obj, int id);


    boolean verificarCedula(String xcedula, int id);

}
