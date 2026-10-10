package com.congreso.backend.service.Impl;

import com.congreso.backend.entities.BoletasContratosE;
import com.congreso.backend.entities.Dto.BoletasContratosE2Dto;
import com.congreso.backend.entities.Dto.BoletasContratosEDto;
import com.congreso.backend.entities.Dto.InquilinoDetalleDto;
import com.congreso.backend.entities.Dto.McontratosEDto;
import com.congreso.backend.entities.McontratosE;
import com.congreso.backend.mapper.BoletasContratosMapper;
import com.congreso.backend.mapper.McontratosMapper;
import com.congreso.backend.repositoryE.BoletasContratosRepo;
import com.congreso.backend.repositoryE.InquilinosRepo;
import com.congreso.backend.repositoryE.McontratosRepo;
import com.congreso.backend.service.BoletasContratosS;
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
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class BoletasContratosImplS implements BoletasContratosS {
    private final CustomResponseBuilder customResponseBuilder;
    private final BoletasContratosRepo boletasRepo;
    private final InquilinosRepo inquilinosRepo;
    @Override
    public PaginatedResponse<BoletasContratosEDto> BoletasContratosByCocli(long cicli, Pageable pageable) {
//        Page<McontratosE> page2 = mcontratosRepo.boletasByInquilinos(cicli,pageable);
//        Page<BoletasContratosEDto> page =  page2.map(BoletasContratosMapper::toDto);
//        return PaginationUtils.toPaginatedResponse(page);
        return null;
    }
    @Transactional(readOnly = true)
    @Override
    public ResponseEntity<ApiResponse> obtenerDetalleInquilino(Long id) {
        Optional<InquilinoDetalleDto> inquilinos = inquilinosRepo.findInquilinoConContratosById(id);
        if (!inquilinos.isPresent()) {
                throw new IllegalArgumentException("Error, el Inquilino con ID " + id + " no existe.");
        }
        return customResponseBuilder.buildResponse(HttpStatus.OK.value(), "listado de Inqulinos exitoso.", inquilinos);
    }

//    @Override
//    public ResponseEntity<ApiResponse> obtenerBoletasBycodcon(String xcodcon) {
//        List<BoletasContratosE2Dto> boletas = boletasRepo.findByMcontratos_Codcon(xcodcon);
//        return customResponseBuilder.buildResponse(HttpStatus.OK.value(), "listado de Boletas exitoso.", boletas);
//    }

    @Override
    public PaginatedResponse<BoletasContratosE2Dto> obtenerBoletasBycodcon(String xcodcon, Pageable pageable) {
        Page<BoletasContratosE2Dto> boletas = boletasRepo.findByMcontratos_Codcon(xcodcon, pageable);
        return PaginationUtils.toPaginatedResponse(boletas);
//        return customResponseBuilder.buildResponse(HttpStatus.OK.value(), "listado de Boletas exitoso.", boletas);
    }
/*
    public PaginatedResponse<InquilinosE> findAll(boolean xestado,String buscar, Pageable pageable) {
        Page<InquilinosE> page = inquilinosRepo.listarInquilinos(xestado,"%"+buscar.trim()+"%", pageable);
        return PaginationUtils.toPaginatedResponse(page);
    }
 */
    @Override
    public ResponseEntity<ApiResponse> obtenerListaDeInquilino() {
        List<InquilinoDetalleDto> inquilinos = inquilinosRepo.listaInquilinoConContratos();  //findInquilinoConContratosById(id);
        return customResponseBuilder.buildResponse(HttpStatus.OK.value(), "listado de Inqulinos exitoso.", inquilinos);
    }
}
