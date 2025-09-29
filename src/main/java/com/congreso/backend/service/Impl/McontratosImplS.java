package com.congreso.backend.service.Impl;

import com.congreso.backend.entities.Dto.McontratosEDto;
import com.congreso.backend.entities.InquilinosE;
import com.congreso.backend.entities.McontratosE;
import com.congreso.backend.entities.forms.McontratosForms;
import com.congreso.backend.mapper.McontratosMapper;
import com.congreso.backend.repositoryE.McontratosRepo;
import com.congreso.backend.service.McontratosS;
import com.congreso.backend.utils.ApiResponse;
import com.congreso.backend.utils.PaginatedResponse;
import com.congreso.backend.utils.PaginationUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;

@Slf4j
@RequiredArgsConstructor
@Service
public class McontratosImplS implements McontratosS {
    private final McontratosRepo mcontratosRepo;

    @Override
    public PaginatedResponse<McontratosE> findAll(int xestado, String buscar, Date fechaini, Date fechafin, Pageable pageable) {
        Page<McontratosE> page = mcontratosRepo.listarMcontratos(xestado,"%"+buscar.trim()+"%",fechaini,fechafin,pageable);
        return PaginationUtils.toPaginatedResponse(page);
    }

    @Override
    public PaginatedResponse<McontratosEDto> findAll_2(int xestado, String buscar, Date fechaini, Date fechafin, Pageable pageable) {
        Page<McontratosE> page2 = mcontratosRepo.listarMcontratos(xestado,"%"+buscar.trim()+"%",fechaini,fechafin,pageable);
        Page<McontratosEDto> page =  page2.map(McontratosMapper::toDto);
        return PaginationUtils.toPaginatedResponse(page);
    }

    @Override
    public ResponseEntity<ApiResponse> save(McontratosForms obj) {
        return null;
    }
}
