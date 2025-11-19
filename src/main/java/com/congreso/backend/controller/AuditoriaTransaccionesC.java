package com.congreso.backend.controller;

import com.congreso.backend.entities.AuditoriaTransaccionesE;
import com.congreso.backend.utils.PaginatedResponse;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;

public interface AuditoriaTransaccionesC {
    PaginatedResponse<AuditoriaTransaccionesE> findAll(String buscar, LocalDate fechaini, LocalDate fechafin, String tipoOperacoin, Pageable pageable);
}
