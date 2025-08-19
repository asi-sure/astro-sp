package com.congreso.backend.service;

import com.congreso.backend.entities.Dto.SeccionesEDto;
import com.congreso.backend.entities.Dto.SectoresEDto;
import com.congreso.backend.entities.SeccionesE;
import com.congreso.backend.entities.SectoresE;
import com.congreso.backend.enumeration.Tipo_persons;
import com.congreso.backend.model.Secciones;
import com.congreso.backend.model.Sectores;
import com.congreso.backend.utils.ApiResponse;
import com.congreso.backend.utils.PaginatedResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface SeccionesS {
    PaginatedResponse<SeccionesE> findAll(int xestado, String buscar, Pageable pageable);
    PaginatedResponse<SeccionesEDto> findAll_dto(int xestado, String buscar, Pageable pageable);
    ResponseEntity<ApiResponse> listarSeccionesPorSectoresDto(int estado, int cods);
    ResponseEntity<ApiResponse> save(Secciones obj);
    ResponseEntity<ApiResponse> update(Secciones obj, int id);
}
