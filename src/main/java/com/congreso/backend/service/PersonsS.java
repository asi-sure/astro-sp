package com.congreso.backend.service;

import com.congreso.backend.enumeration.Tipo_persons;
import com.congreso.backend.model.Departament;
import com.congreso.backend.model.Person;
import com.congreso.backend.model.Persons;
import com.congreso.backend.utils.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface PersonsS {

//    ResponseEntity<ApiResponse> savePersons(Persons person, MultipartFile file);
    ResponseEntity<ApiResponse> findAll(boolean xstatus, Tipo_persons tipoper);
    ResponseEntity<ApiResponse> findById(int id);
    ResponseEntity<ApiResponse> delete(int id);
    ResponseEntity<ApiResponse> savePersons(Persons person, MultipartFile file);
    ResponseEntity<ApiResponse> update(Persons obj, MultipartFile file, int id);
    ResponseEntity<ApiResponse> updateTipoper(Tipo_persons tipoper, int id);

}
