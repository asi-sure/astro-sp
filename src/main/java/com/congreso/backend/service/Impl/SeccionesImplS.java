package com.congreso.backend.service.Impl;

import com.congreso.backend.entities.Dto.SeccionesEDto;
import com.congreso.backend.entities.Dto.SectoresEDto;
import com.congreso.backend.entities.SeccionesE;
import com.congreso.backend.entities.SectoresE;
import com.congreso.backend.model.Secciones;
import com.congreso.backend.repository.SeccionesR;
import com.congreso.backend.repository.SectoresR;
import com.congreso.backend.reposotoryE.SeccionesRepo;
import com.congreso.backend.reposotoryE.SectoresRepo;
import com.congreso.backend.service.SeccionesS;
import com.congreso.backend.utils.ApiResponse;
import com.congreso.backend.utils.CustomResponseBuilder;
import com.congreso.backend.utils.PaginatedResponse;
import com.congreso.backend.utils.PaginationUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class SeccionesImplS implements SeccionesS {
    private final SeccionesRepo seccionesRepo;
    private final SeccionesR seccionesR;
    private final CustomResponseBuilder customResponseBuilder;

    @Override
    public PaginatedResponse<SeccionesE> findAll(int xestado, String buscar, Pageable pageable) {
        Page<SeccionesE> page = seccionesRepo.listarSecciones(xestado,"%"+buscar.trim()+"%", pageable);
        return PaginationUtils.toPaginatedResponse(page);
    }
    @Override
    public PaginatedResponse<SeccionesEDto> findAll_dto(int xestado, String buscar, Pageable pageable) {
        Page<SeccionesEDto> page = seccionesRepo.listarSeccionesDto(xestado,"%"+buscar.trim()+"%", pageable);
        return PaginationUtils.toPaginatedResponse(page);
    }
    @Override
    public ResponseEntity<ApiResponse> save(Secciones obj) {
        if (seccionesR.verificarNombre(obj.getNombre(),0)) {
            return customResponseBuilder.buildResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), "El Sector ya Existe.", 0);
        }
        try {
            Long id = seccionesR.save(obj);//guarda inquilin
        } catch (Exception e) {
            e.printStackTrace();
            return customResponseBuilder.buildResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error al Guardar los Datos.", 0);
        }
        return customResponseBuilder.buildResponse(HttpStatus.OK.value(), "Consulta exitosa.", null);
    }
    @Override
    public ResponseEntity<ApiResponse> update(Secciones obj, int id) {
        if (seccionesR.verificarNombre(obj.getNombre(),id)) {
            return customResponseBuilder.buildResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), "La Sección ya Existe.", 0);
        }
        boolean updated = seccionesR.update(obj, id);//MODIFICA DATOS
        if (!updated) {
            return customResponseBuilder.buildResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error al Modificar los datos.", 0);
        }
        return customResponseBuilder.buildResponse(HttpStatus.OK.value(), "Actualizacion exitosa.", updated);
    }
}
