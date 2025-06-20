package com.congreso.backend.service.Impl;

import com.congreso.backend.model.Departament;
import com.congreso.backend.model.Menu;
import com.congreso.backend.repository.DepartamentR;
import com.congreso.backend.repository.MenuR;
import com.congreso.backend.service.MenuS;
import com.congreso.backend.utils.ApiResponse;
import com.congreso.backend.utils.CustomResponseBuilder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class MenuImplS implements MenuS {
    private final MenuR menuR;
    private final CustomResponseBuilder customResponseBuilder;

    @Override
    public ResponseEntity<ApiResponse> findAll() {
        List<Menu> menu = menuR.findAll();
        return customResponseBuilder.buildResponse(HttpStatus.OK.value(), "Consulta exitosa.", menu);
    }
}
