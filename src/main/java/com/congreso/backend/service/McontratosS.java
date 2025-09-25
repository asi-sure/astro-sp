package com.congreso.backend.service;

import com.congreso.backend.entities.InquilinosE;
import com.congreso.backend.entities.McontratosE;
import com.congreso.backend.utils.PaginatedResponse;
import org.springframework.data.domain.Pageable;

public interface McontratosS {
    PaginatedResponse<McontratosE> findAll(int xestado, Pageable pageable);

}
