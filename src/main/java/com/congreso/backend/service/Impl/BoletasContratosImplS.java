package com.congreso.backend.service.Impl;

import com.congreso.backend.entities.Dto.BoletasContratosEDto;
import com.congreso.backend.entities.Dto.McontratosEDto;
import com.congreso.backend.entities.McontratosE;
import com.congreso.backend.mapper.BoletasContratosMapper;
import com.congreso.backend.mapper.McontratosMapper;
import com.congreso.backend.repositoryE.McontratosRepo;
import com.congreso.backend.service.BoletasContratosS;
import com.congreso.backend.utils.CustomResponseBuilder;
import com.congreso.backend.utils.PaginatedResponse;
import com.congreso.backend.utils.PaginationUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class BoletasContratosImplS implements BoletasContratosS {
    private final CustomResponseBuilder customResponseBuilder;
    private final McontratosRepo mcontratosRepo;
    @Override
    public PaginatedResponse<BoletasContratosEDto> BoletasContratosByCocli(long cicli, Pageable pageable) {
//        Page<McontratosE> page2 = mcontratosRepo.boletasByInquilinos(cicli,pageable);
//        Page<BoletasContratosEDto> page =  page2.map(BoletasContratosMapper::toDto);
//        return PaginationUtils.toPaginatedResponse(page);
        return null;
    }
}
