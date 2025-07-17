package com.congreso.backend.service.Impl;

import com.congreso.backend.model.Rolper;
import com.congreso.backend.model.dto.PersonsDto;
import com.congreso.backend.repository.RoleR;
import com.congreso.backend.service.RoleS;
import com.congreso.backend.utils.ApiResponse;
import com.congreso.backend.utils.CustomResponseBuilder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.congreso.backend.model.Role;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class RoleImplS implements RoleS {
    private final RoleR roleR;
    private final CustomResponseBuilder customResponseBuilder;

    @Override
    public ResponseEntity<ApiResponse> findAll(boolean xstatus) {
        List<Role> roles = roleR.findAll(xstatus);
        return customResponseBuilder.buildResponse(HttpStatus.OK.value(), "Consulta exitosa.", roles);
    }
    @Override
    public ResponseEntity<ApiResponse> findById(Long id) {
        Role role = roleR.getById(id);
        return customResponseBuilder.buildResponse(HttpStatus.OK.value(), "Consulta exitosa.", role);
    }

    @Override
    public ResponseEntity<ApiResponse> grantPersons(Rolper role) {
        Long id = roleR.grantPersons(role);
        return customResponseBuilder.buildResponse(HttpStatus.OK.value(), "Consulta exitosa.", 0);
    }

    @Override
    public ResponseEntity<ApiResponse> revokePersons(int idPerson, int idRol) {
        Boolean res = roleR.revokePersons(idPerson, idRol);
        if (!res){
            return customResponseBuilder.buildResponse(HttpStatus.OK.value(), "No existen datos para eliminar", 0);
        }
        return customResponseBuilder.buildResponse(HttpStatus.OK.value(), "Consulta exitosa.", 0);
    }

/*    @Override
    public ResponseEntity<ApiResponse> findById(long id) {
        Role role = roleR.getById(id);
        return customResponseBuilder.buildResponse(HttpStatus.OK.value(), "Consulta exitosa.", role);
    }*/


}
