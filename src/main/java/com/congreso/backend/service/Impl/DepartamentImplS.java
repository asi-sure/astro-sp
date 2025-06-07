package com.congreso.backend.service.Impl;

import com.congreso.backend.model.Departament;
import com.congreso.backend.repository.DepartamentR;
import com.congreso.backend.service.DepartamentS;
import com.congreso.backend.utils.ApiResponse;
import com.congreso.backend.utils.CustomResponseBuilder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class DepartamentImplS implements DepartamentS {
    private final DepartamentR departamentR;
    private final CustomResponseBuilder customResponseBuilder;

    @Override
    public ResponseEntity<ApiResponse> findAll() {
        List<Departament> departaments = departamentR.findAll();
        return customResponseBuilder.buildResponse(HttpStatus.OK.value(), "Consulta exitosa.", departaments);
    }

    @Override
    public ResponseEntity<ApiResponse> findById(Integer id) {
        Departament department = departamentR.findById(id);
        return customResponseBuilder.buildResponse(HttpStatus.OK.value(), "Consulta exitosa.", department);
    }

    @Override
    public ResponseEntity<ApiResponse> save(Departament obj) {
        try {
            boolean result = departamentR.save(obj);
            return customResponseBuilder.buildResponse(HttpStatus.OK.value(), "Guardado exitosa.", result);
        } catch (Exception e) {
            log.error("save ", e);
            return customResponseBuilder.buildResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error al guardar el departamento", e.getMessage());
        }
    }

    @Override
    public ResponseEntity<ApiResponse> update(Departament obj, Integer id) {
        try {
            boolean updated = departamentR.update(obj, id);
            return customResponseBuilder.buildResponse(HttpStatus.OK.value(), "Actualizacion exitosa.", updated);
        } catch (Exception e) {
            log.error("update ", e);
            return customResponseBuilder.buildResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error al actualizar el departamento", e.getMessage());
        }
    }

    @Override
    public ResponseEntity<ApiResponse> deleteById(Integer id) {
        boolean deleted = departamentR.deleteById(id);
        return customResponseBuilder.buildResponse(HttpStatus.OK.value(), "Eliminacion exitosa.", deleted);
    }
}
