package com.congreso.backend.controller;

import com.congreso.backend.entities.InquilinosE;
import com.congreso.backend.entities.RubrosE;
import com.congreso.backend.utils.PaginatedResponse;
import org.springframework.data.domain.Pageable;

public interface RubrosC {
    PaginatedResponse<RubrosE> findAll(int xestado, String buscar, Pageable pageable);
}
