package com.congreso.backend.service.Impl;


import com.congreso.backend.entities.Dto.SectoresEDto;
import com.congreso.backend.entities.SectoresE;
import com.congreso.backend.model.Inquilinos_ubic;
import com.congreso.backend.model.Sectores;
import com.congreso.backend.repository.SectoresR;
import com.congreso.backend.reposotoryE.SectoresRepo;
import com.congreso.backend.service.SectoresS;
import com.congreso.backend.utils.ApiResponse;
import com.congreso.backend.utils.CustomResponseBuilder;
import com.congreso.backend.utils.PaginatedResponse;
import com.congreso.backend.utils.PaginationUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Slf4j
@RequiredArgsConstructor
@Service
public class SectoresImplS implements SectoresS {
    private final SectoresRepo sectoresRepo;
    private final SectoresR sectoresR;
    private final CustomResponseBuilder customResponseBuilder;

    @Override
    public PaginatedResponse<SectoresE> findAll(int xestado, String buscar, Pageable pageable) {
        Page<SectoresE> page = sectoresRepo.listarSectores(xestado,"%"+buscar.trim()+"%", pageable);
        return PaginationUtils.toPaginatedResponse(page);
    }
    @Override
    public PaginatedResponse<SectoresEDto> findAll_dto(int xestado, String buscar, Pageable pageable) {
        Page<SectoresEDto> page = sectoresRepo.listarSectoresDto(xestado,"%"+buscar.trim()+"%", pageable);
        return PaginationUtils.toPaginatedResponse(page);
    }
    @Override
    public ResponseEntity<ApiResponse> save(Sectores obj) {
        if (sectoresR.verificarNombre(obj.getNombre())) {
            return customResponseBuilder.buildResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), "El Sector ya Existe.", 0);
        }
        try {
            Long id = sectoresR.save(obj);//guarda inquilin
        } catch (Exception e) {
            e.printStackTrace();
            return customResponseBuilder.buildResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error al Guardar los Datos.", 0);
        }
        return customResponseBuilder.buildResponse(HttpStatus.OK.value(), "Consulta exitosa.", null);
    }
}
