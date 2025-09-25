package com.congreso.backend.controller;

import com.congreso.backend.entities.InquilinosE;
import com.congreso.backend.entities.McontratosE;
import com.congreso.backend.utils.PaginatedResponse;
import org.springframework.data.domain.Pageable;

public interface McontratosC {
    PaginatedResponse<McontratosE> findAll(int xestado, Pageable pageable);
}
