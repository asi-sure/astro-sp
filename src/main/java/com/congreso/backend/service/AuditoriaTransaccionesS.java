package com.congreso.backend.service;

import com.congreso.backend.entities.AuditoriaTransaccionesE;
import com.congreso.backend.utils.PaginatedResponse;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;

public interface AuditoriaTransaccionesS {
    PaginatedResponse<AuditoriaTransaccionesE> findAll(String buscar, LocalDate fechaini, LocalDate fechafin,String tipoOperacoin, Pageable pageable);
}
