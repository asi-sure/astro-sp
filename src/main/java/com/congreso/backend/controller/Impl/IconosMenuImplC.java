package com.congreso.backend.controller.Impl;

import com.congreso.backend.controller.IconosMenuC;
import com.congreso.backend.entities.Iconos_menuE;
import com.congreso.backend.service.Iconos_menuS;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/")
public class IconosMenuImplC implements IconosMenuC {
    private final Iconos_menuS iconosMenuS;

    @Override
    @GetMapping("iconos")
    public List<Iconos_menuE> listaIconosMenu() {
        return iconosMenuS.findAll();
    }
}
