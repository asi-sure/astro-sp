package com.congreso.backend.service.Impl;

import com.congreso.backend.entities.InquilinosE;
import com.congreso.backend.entities.McontratosE;
import com.congreso.backend.repositoryE.McontratosRepo;
import com.congreso.backend.service.McontratosS;
import com.congreso.backend.utils.PaginatedResponse;
import com.congreso.backend.utils.PaginationUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
}
