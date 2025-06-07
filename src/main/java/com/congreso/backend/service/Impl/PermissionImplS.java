package com.congreso.backend.service.Impl;

import com.congreso.backend.model.Permission;
import com.congreso.backend.repository.PermissionR;
import com.congreso.backend.service.PermissionS;
import com.congreso.backend.utils.ApiResponse;
import com.congreso.backend.utils.CustomResponseBuilder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class PermissionImplS implements PermissionS {
    private final PermissionR permissionR;
    private final CustomResponseBuilder customResponseBuilder;

    @Override
    public ResponseEntity<ApiResponse> findAll() {
        List<Permission> permissionList = permissionR.findAll();
        return customResponseBuilder.buildResponse(HttpStatus.OK.value(), "Consulta exitosa.", permissionList);
    }

    @Override
    public ResponseEntity<ApiResponse> findById(Integer id) {
        Permission permission = permissionR.findById(id);
        return customResponseBuilder.buildResponse(HttpStatus.OK.value(), "Consulta exitosa.", permission);
    }

    @Override
    public ResponseEntity<ApiResponse> save(Permission permission) {
        boolean result = permissionR.save(permission);
        return customResponseBuilder.buildResponse(HttpStatus.OK.value(), "Refistro exitoso.", result);
    }

    @Override
    public ResponseEntity<ApiResponse> update(Permission obj, Integer id) {
        boolean result = permissionR.update(obj, id);
        return customResponseBuilder.buildResponse(HttpStatus.OK.value(), "Actualizacion exitoso.", result);
    }

    @Override
    public ResponseEntity<ApiResponse> deleteById(Integer id) {
        boolean result = permissionR.deleteById(id);
        return customResponseBuilder.buildResponse(HttpStatus.OK.value(), "Eliminacion exitoso.", result);
    }
}
