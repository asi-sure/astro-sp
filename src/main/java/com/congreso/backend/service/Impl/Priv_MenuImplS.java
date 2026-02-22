package com.congreso.backend.service.Impl;

import com.congreso.backend.entities.Priv_MenuE;
import com.congreso.backend.entities.PrivilegiosE;
import com.congreso.backend.repositoryE.Priv_MenuRepo;
import com.congreso.backend.service.Priv_MenuS;
import com.congreso.backend.utils.ApiResponse;
import com.congreso.backend.utils.CustomResponseBuilder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class Priv_MenuImplS implements Priv_MenuS {
    private final Priv_MenuRepo priv_menuRepo;
    private final CustomResponseBuilder customResponseBuilder;

    @Override
    public ResponseEntity<ApiResponse> findAll() {
        List<Priv_MenuE> priv_menu = priv_menuRepo.findAll();
        return customResponseBuilder.buildResponse(HttpStatus.OK.value(), "Lista privilegios y menues..!", priv_menu);
    }
}
