package com.congreso.backend.service.Impl;

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

@Slf4j
@RequiredArgsConstructor
@Service
public class RoleImplS implements RoleS {
    private final RoleR roleR;
    private final CustomResponseBuilder customResponseBuilder;

    @Override
    public ResponseEntity<ApiResponse> findById(Long id) {
        Role role = roleR.getById(id);
        return customResponseBuilder.buildResponse(HttpStatus.OK.value(), "Consulta exitosa.", role);
    }

/*    @Override
    public ResponseEntity<ApiResponse> findById(long id) {
        Role role = roleR.getById(id);
        return customResponseBuilder.buildResponse(HttpStatus.OK.value(), "Consulta exitosa.", role);
    }*/


}
