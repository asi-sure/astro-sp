package com.congreso.backend.controller;

import com.congreso.backend.entities.Dto.McontratosEDto;
import com.congreso.backend.entities.InquilinosE;
import com.congreso.backend.entities.McontratosE;
import com.congreso.backend.utils.PaginatedResponse;
import org.springframework.data.domain.Pageable;

import java.util.Date;

public interface McontratosC {
    PaginatedResponse<McontratosE> findAll(int xestado, String buscar, Date fechaini, Date fechafin, Pageable pageable);
    PaginatedResponse<McontratosEDto> findAll_2(int xestado, String buscar, Date fechaini, Date fechafin, Pageable pageable);
}
