package com.congreso.backend.service.Impl;

import com.congreso.backend.entities.Iconos_menuE;
import com.congreso.backend.repositoryE.Iconos_menuRepo;
import com.congreso.backend.service.Iconos_menuS;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class Iconos_menuImplS implements Iconos_menuS {

    private final Iconos_menuRepo iconos_menuRepo;

    @Override
    public List<Iconos_menuE> findAll() {
        return iconos_menuRepo.findAll();
    }


}
