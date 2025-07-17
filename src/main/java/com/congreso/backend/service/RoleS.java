package com.congreso.backend.service;

import com.congreso.backend.enumeration.Tipo_persons;
import com.congreso.backend.model.Persons;
import com.congreso.backend.model.Rolper;
import com.congreso.backend.utils.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface RoleS {
    ResponseEntity<ApiResponse> findAll(boolean xstatus);
    ResponseEntity<ApiResponse> findById(Long id);
    ResponseEntity<ApiResponse> grantPersons(Rolper role);
    ResponseEntity<ApiResponse> revokePersons(int idPerson, int idRol);

}
