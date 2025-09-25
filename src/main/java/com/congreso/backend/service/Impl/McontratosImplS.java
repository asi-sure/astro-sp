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

@Slf4j
@RequiredArgsConstructor
@Service
public class McontratosImplS implements McontratosS {
    private final McontratosRepo mcontratosRepo;

    @Override
    public PaginatedResponse<McontratosE> findAll(int xestado, Pageable pageable) {
        Page<McontratosE> page = mcontratosRepo.listarMcontratos(xestado,pageable);
        return PaginationUtils.toPaginatedResponse(page);
    }
}
