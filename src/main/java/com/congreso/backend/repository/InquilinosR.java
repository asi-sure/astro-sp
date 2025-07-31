package com.congreso.backend.repository;

import com.congreso.backend.model.Inquilinos_ubic;
import com.congreso.backend.model.Persons;
import com.congreso.backend.model.dto.PersonsDto;
import com.congreso.backend.model.forms.InquilinosForm;

import java.util.List;

public interface InquilinosR {

    List<InquilinosForm> findAll(boolean xestado);
    Long save(InquilinosForm obj);
    Long saveGps(Inquilinos_ubic obj);
    boolean update(InquilinosForm obj, int id);
    boolean updateUrlUbicacion(String urlImg, int id);
    boolean updateGps(Inquilinos_ubic obj, int id);
    boolean delete(int id);
    public boolean verificarExistIdInquilinosGPS(int id);
    boolean verificarCedula(String xcedula, int id);

}
