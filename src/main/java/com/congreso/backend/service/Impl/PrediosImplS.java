package com.congreso.backend.service.Impl;

import com.congreso.backend.entities.Dto.SeccionesEDto;
import com.congreso.backend.entities.PrediosE;
import com.congreso.backend.entities.SeccionesE;
import com.congreso.backend.reposotoryE.PrediosRepo;
import com.congreso.backend.service.PrediosS;
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

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class PrediosImplS implements PrediosS {
    private final PrediosRepo prediosRepo;
//    private final PrediosR prediosR;
    private final CustomResponseBuilder customResponseBuilder;

    @Override
    public PaginatedResponse<PrediosE> findAll(int xestado, String buscar, Pageable pageable) {
        Page<PrediosE> page = prediosRepo.listarPredios(xestado,"%"+buscar.trim()+"%", pageable);
        return PaginationUtils.toPaginatedResponse(page);
    }

    @Override
    public ResponseEntity<ApiResponse> listarPrediosPorSeccion(int estado, int codsec) {
        List<PrediosE> predios = prediosRepo.listarPrediosPorSecciones(estado,codsec);
        return customResponseBuilder.buildResponse(HttpStatus.OK.value(), "Consulta exitosa.", predios);
    }




} //End of the function
