package com.congreso.backend.service;

import com.congreso.backend.entities.Dto.McontratosEDto;
import com.congreso.backend.entities.InquilinosE;
import com.congreso.backend.entities.McontratosE;
import com.congreso.backend.utils.PaginatedResponse;
import org.springframework.data.domain.Pageable;

import java.util.Date;

public interface McontratosS {
    PaginatedResponse<McontratosE> findAll(int xestado, String buscar,Date fechaini,Date fechafin, Pageable pageable);
    PaginatedResponse<McontratosEDto> findAll_2(int xestado, String buscar, Date fechaini, Date fechafin, Pageable pageable);

}
