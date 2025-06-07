package com.congreso.backend.service.Impl;

import com.congreso.backend.model.Team;
import com.congreso.backend.repository.TeamR;
import com.congreso.backend.service.TeamS;
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
public class TeamImplS implements TeamS {
    private final TeamR teamR;
    private final CustomResponseBuilder customResponseBuilder;

    @Override
    public ResponseEntity<ApiResponse> findAll() {
        List<Team> teams = teamR.findAll();
        return customResponseBuilder.buildResponse(HttpStatus.OK.value(), "Consulta exitosa.");
    }

    @Override
    public ResponseEntity<ApiResponse> findById(Integer id) {
        Team team = teamR.findById(id);
        return customResponseBuilder.buildResponse(HttpStatus.OK.value(), "Consulta exitosa.");
    }

    @Override
    public ResponseEntity<ApiResponse> save(Team team) {
        try {
            boolean result = teamR.save(team);
            return customResponseBuilder.buildResponse(HttpStatus.OK.value(), "Registro exitoso", result);
        } catch (Exception e) {
            log.error("Save", e);
            return customResponseBuilder.buildResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error al guardar el registro.");
        }
    }

    @Override
    public ResponseEntity<ApiResponse> update(Team obj, Integer id) {
        try {
            boolean result = teamR.update(obj, id);
            return customResponseBuilder.buildResponse(HttpStatus.OK.value(), "Actualizacion exitoso", result);
        } catch (Exception e) {
            log.error("update", e);
            return customResponseBuilder.buildResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error al actualziar el registro.");
        }
    }

    @Override
    public ResponseEntity<ApiResponse> deleteById(Integer id) {
        boolean result = teamR.deleteById(id);
        return customResponseBuilder.buildResponse(HttpStatus.OK.value(), "Eliminacion exitoso", result);
    }
}
