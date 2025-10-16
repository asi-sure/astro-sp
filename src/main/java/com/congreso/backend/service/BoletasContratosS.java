package com.congreso.backend.service;

import com.congreso.backend.entities.Dto.BoletasContratosEDto;
import com.congreso.backend.entities.Dto.McontratosEDto;
import com.congreso.backend.utils.PaginatedResponse;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;

public interface BoletasContratosS {
    PaginatedResponse<BoletasContratosEDto> BoletasContratosByCocli(long cicli, Pageable pageable);
}
