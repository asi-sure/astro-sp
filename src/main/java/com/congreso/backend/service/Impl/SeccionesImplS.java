package com.congreso.backend.service.Impl;

import com.congreso.backend.entities.Dto.SeccionesEDto;
import com.congreso.backend.entities.Dto.SectoresEDto;
import com.congreso.backend.entities.SeccionesE;
import com.congreso.backend.entities.SectoresE;
import com.congreso.backend.repository.SectoresR;
import com.congreso.backend.reposotoryE.SeccionesRepo;
import com.congreso.backend.reposotoryE.SectoresRepo;
import com.congreso.backend.service.SeccionesS;
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
public class SeccionesImplS implements SeccionesS {
    private final SeccionesRepo seccionesRepo;
//    private final SeccionesR sectoresR;
    private final CustomResponseBuilder customResponseBuilder;

    @Override
    public PaginatedResponse<SeccionesE> findAll(int xestado, String buscar, Pageable pageable) {
        Page<SeccionesE> page = seccionesRepo.listarSecciones(xestado,"%"+buscar.trim()+"%", pageable);
        return PaginationUtils.toPaginatedResponse(page);
    }

    @Override
    public PaginatedResponse<SeccionesEDto> findAll_dto(int xestado, String buscar, Pageable pageable) {
        Page<SeccionesEDto> page = seccionesRepo.listarSeccionesDto(xestado,"%"+buscar.trim()+"%", pageable);
        return PaginationUtils.toPaginatedResponse(page);
    }
}
