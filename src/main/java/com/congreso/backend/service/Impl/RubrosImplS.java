package com.congreso.backend.service.Impl;

import com.congreso.backend.entities.InquilinosE;
import com.congreso.backend.entities.RubrosE;
import com.congreso.backend.repositoryE.InquilinosRepo;
import com.congreso.backend.repositoryE.RubrosRepo;
import com.congreso.backend.service.RubrosS;
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
public class RubrosImplS implements RubrosS {

    private final RubrosRepo rubrosRepo;

    @Override
    public PaginatedResponse<RubrosE> findAll(int xestado, String buscar, Pageable pageable) {
        Page<RubrosE> page = rubrosRepo.listarRubros(xestado,"%"+buscar.trim()+"%", pageable);
        return PaginationUtils.toPaginatedResponse(page);
    }

}
