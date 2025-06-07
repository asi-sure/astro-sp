package com.congreso.backend.service.Impl;

import com.congreso.backend.model.Region;
import com.congreso.backend.repository.RegionR;
import com.congreso.backend.service.RegionS;
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
public class RegionImplS implements RegionS {
    private final RegionR regionR;
    private final CustomResponseBuilder customResponseBuilder;

    @Override
    public ResponseEntity<ApiResponse> findAll() {
        List<Region> regions = regionR.findAll();
        return customResponseBuilder.buildResponse(HttpStatus.OK.value(), "Consulta exitosa.");
    }

    @Override
    public ResponseEntity<ApiResponse> findById(Integer id) {
        Region region = regionR.findById(id);
        return customResponseBuilder.buildResponse(HttpStatus.OK.value(), "Consulta exitosa.", region);
    }

    @Override
    public ResponseEntity<ApiResponse> save(Region obj) {
        try {
            boolean saved = regionR.save(obj);
            return customResponseBuilder.buildResponse(HttpStatus.OK.value(), "Registro exitosa.", saved);
        } catch (Exception e) {
            log.error("save ", e);
            return customResponseBuilder.buildResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error al guardar el registro.", e.getMessage());
        }
    }

    @Override
    public ResponseEntity<ApiResponse> update(Region obj, Integer id) {
        try {
            boolean updated = regionR.update(obj, id);
            return customResponseBuilder.buildResponse(HttpStatus.OK.value(), "Actualizacion exitosa.", updated);
        } catch (Exception e) {
            log.error("update ", e);
            return customResponseBuilder.buildResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error al actualizar el registro.", e.getMessage());
        }
    }

    @Override
    public ResponseEntity<ApiResponse> deleteById(Integer id) {
        boolean deleted = regionR.deleteById(id);
        return customResponseBuilder.buildResponse(HttpStatus.OK.value(), "Eliminacion exitosa.", deleted);
    }
}
