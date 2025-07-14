package com.congreso.backend.service.Impl;

import com.congreso.backend.model.forms.InquilinosForm;
import com.congreso.backend.repository.InquilinosR;
import com.congreso.backend.service.InquilinosS;
import com.congreso.backend.utils.ApiResponse;
import com.congreso.backend.utils.CustomResponseBuilder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class InquilinosImplS implements InquilinosS {
    private final InquilinosR inquilinosR;
    private final CustomResponseBuilder customResponseBuilder;
    @Value("${app.upload.photo-dir}")
    private String photoDirectory;
    @Value("${app.load.photo-dir}")
    private String photoDir;

    @Override
    public ResponseEntity<ApiResponse> findAll(boolean xestado) {
        List<InquilinosForm> inquilinos = inquilinosR.findAll(xestado);
        return customResponseBuilder.buildResponse(HttpStatus.OK.value(), "Consulta exitosa.", inquilinos);
    }
}
