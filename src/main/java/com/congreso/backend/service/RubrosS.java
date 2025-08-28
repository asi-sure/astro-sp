package com.congreso.backend.service;

import com.congreso.backend.entities.InquilinosE;
import com.congreso.backend.entities.RubrosE;
import com.congreso.backend.utils.PaginatedResponse;
import org.springframework.data.domain.Pageable;

public interface RubrosS {
    PaginatedResponse<RubrosE> findAll(int xestado, String buscar, Pageable pageable);
}
