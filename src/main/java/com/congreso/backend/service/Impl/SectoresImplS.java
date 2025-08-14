package com.congreso.backend.service.Impl;


import com.congreso.backend.entities.Dto.SectoresEDto;
import com.congreso.backend.entities.SectoresE;
import com.congreso.backend.reposotoryE.SectoresRepo;
import com.congreso.backend.service.SectoresS;
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
public class SectoresImplS implements SectoresS {
    private final SectoresRepo sectoresRepo;

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
}
