package com.congreso.backend.service.Impl;

import com.congreso.backend.entities.AuditoriaTransaccionesE;
import com.congreso.backend.entities.McontratosE;
import com.congreso.backend.repositoryE.AuditoriaTransaccionesRepo;
import com.congreso.backend.service.AuditoriaTransaccionesS;
import com.congreso.backend.utils.CustomResponseBuilder;
import com.congreso.backend.utils.PaginatedResponse;
import com.congreso.backend.utils.PaginationUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Slf4j
@RequiredArgsConstructor
@Service
public class AuditoriaTransaccionesImplS implements AuditoriaTransaccionesS {
    private final CustomResponseBuilder customResponseBuilder;
    private final AuditoriaTransaccionesRepo auditoriaTransaccionesRepo;
    @Override
    public PaginatedResponse<AuditoriaTransaccionesE> findAll(String buscar, LocalDate fechaini, LocalDate fechafin, String tipoOperacion, Pageable pageable) {
        Page<AuditoriaTransaccionesE> page = auditoriaTransaccionesRepo.listarAuditoriasTransacciones("%"+buscar.trim()+"%",fechaini,fechafin,"%"+tipoOperacion.trim()+"%",pageable);
        return PaginationUtils.toPaginatedResponse(page);
    }
} //end of class
