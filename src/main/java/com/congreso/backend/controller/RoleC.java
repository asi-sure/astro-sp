package com.congreso.backend.controller;

import com.congreso.backend.controller.request.AuthLoginRequest;
import com.congreso.backend.enumeration.Tipo_persons;
import com.congreso.backend.model.Persons;
import com.congreso.backend.model.Role;
import com.congreso.backend.model.Rolper;
import com.congreso.backend.utils.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

public interface RoleC {
    ResponseEntity<ApiResponse> findAll(boolean xstatus);
    ResponseEntity<ApiResponse> grantPersons(Rolper role);
    ResponseEntity<ApiResponse> revokePersons(int idPerson, int idRol);
    ResponseEntity<ApiResponse> save(@RequestBody Role role);
    ResponseEntity<ApiResponse> update(Role role, int id);
    ResponseEntity<ApiResponse> delete(int id);
} //the end
