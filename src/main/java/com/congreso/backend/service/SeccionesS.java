package com.congreso.backend.service;

import com.congreso.backend.entities.Dto.SeccionesEDto;
import com.congreso.backend.entities.Dto.SectoresEDto;
import com.congreso.backend.entities.SeccionesE;
import com.congreso.backend.entities.SectoresE;
import com.congreso.backend.utils.PaginatedResponse;
import org.springframework.data.domain.Pageable;

public interface SeccionesS {
    PaginatedResponse<SeccionesE> findAll(int xestado, String buscar, Pageable pageable);
    PaginatedResponse<SeccionesEDto> findAll_dto(int xestado, String buscar, Pageable pageable);
}
