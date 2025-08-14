package com.congreso.backend.service;

import com.congreso.backend.entities.Dto.SectoresEDto;
import com.congreso.backend.entities.InquilinosE;
import com.congreso.backend.entities.SectoresE;
import com.congreso.backend.utils.PaginatedResponse;
import org.springframework.data.domain.Pageable;

public interface SectoresS {
    PaginatedResponse<SectoresE> findAll(int xestado, String buscar, Pageable pageable);
    PaginatedResponse<SectoresEDto> findAll_dto(int xestado, String buscar, Pageable pageable);
}
