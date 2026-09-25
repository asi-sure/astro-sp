package com.congreso.backend.service.Impl;

import com.congreso.backend.entities.GeneralE;
import com.congreso.backend.model.Menu;
import com.congreso.backend.repositoryE.GeneralRepo;
import com.congreso.backend.service.GeneralS;
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
public class GeneralImplS implements GeneralS {
    private final GeneralRepo generalRepo;
    private final CustomResponseBuilder customResponseBuilder;

    @Override
    public ResponseEntity<ApiResponse> findAll() {
        List<GeneralE> general = generalRepo.findAll();
        return customResponseBuilder.buildResponse(HttpStatus.OK.value(), "Consulta exitosa.", general);
    }
}
