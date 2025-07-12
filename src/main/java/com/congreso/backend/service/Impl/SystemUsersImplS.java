package com.congreso.backend.service.Impl;

import com.congreso.backend.model.SystemUsers;
import com.congreso.backend.model.dto.SystemUsersDto;
import com.congreso.backend.repository.PersonsR;
import com.congreso.backend.repository.SystemUsersR;
import com.congreso.backend.service.SystemUsersS;
import com.congreso.backend.utils.ApiResponse;
import com.congreso.backend.utils.CustomResponseBuilder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Slf4j
@RequiredArgsConstructor
@Service
public class SystemUsersImplS implements SystemUsersS {
    private final SystemUsersR systemUsersR;
    private final CustomResponseBuilder customResponseBuilder;
    private final PasswordEncoder passwordEncoder;

    @Override
    public ResponseEntity<ApiResponse> save(SystemUsersDto user) {
        if (systemUsersR.verificarUserName(user.getUsername())) {
            return customResponseBuilder.buildResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), "El UserName ya Existe.", 0);
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Long idper = systemUsersR.save(user);
        return customResponseBuilder.buildResponse(HttpStatus.OK.value(), "Consulta exitosa.", null);
    }




}
