package com.congreso.backend.service.Impl;


import com.congreso.backend.model.Rol;
import com.congreso.backend.repository.RoleR;
import com.congreso.backend.service.RolS;
import com.congreso.backend.utils.ApiResponse;
import com.congreso.backend.utils.CustomResponseBuilder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class RolImplS implements RolS {
    private final RoleR roleR;
    private final CustomResponseBuilder customResponseBuilder;

/*    @Override
    public ResponseEntity<ApiResponse> findAll() {
        List<Rol> roles = roleR.findAll();
        return customResponseBuilder.buildResponse(HttpStatus.OK.value(), "Consulta exitosa.", roles);
    }*/

/*    @Override
    public ResponseEntity<ApiResponse> findById(Integer id) {
        Rol rol = roleR.getById(id);
        return customResponseBuilder.buildResponse(HttpStatus.OK.value(), "Consulta exitosa.", rol);
    }*/

/*    @Override
    public ResponseEntity<ApiResponse> save(Rol obj) {
        roleR.save(obj);
        return customResponseBuilder.buildResponse(HttpStatus.CREATED.value(), "Registro exitosa.", obj);
    }

    @Override
    public ResponseEntity<ApiResponse> deleteById(Integer id) {
        roleR.deleteById(id);
        return customResponseBuilder.buildResponse(HttpStatus.OK.value(), "Eliminacion exitosa.", id);
    }*/
}
