package com.congreso.backend.service.Impl;

import com.congreso.backend.entities.MenuE;
import com.congreso.backend.entities.MesubE;
import com.congreso.backend.entities.RoleE;
import com.congreso.backend.entities.SubmenuE;
import com.congreso.backend.exception.type.DataAlreadyExistsException;
import com.congreso.backend.exception.type.ResourceNotFoundException;
import com.congreso.backend.model.Departament;
import com.congreso.backend.model.Menu;
import com.congreso.backend.model.Submenu;
import com.congreso.backend.model.dto.MesubDto;
import com.congreso.backend.model.dto.SubmenuPrivDto;
import com.congreso.backend.repository.DepartamentR;
import com.congreso.backend.repository.MenuR;
import com.congreso.backend.repositoryE.MenuRepo;
import com.congreso.backend.repositoryE.MesubRepo;
import com.congreso.backend.repositoryE.RoleRepo;
import com.congreso.backend.repositoryE.SubmenuRepo;
import com.congreso.backend.service.MenuS;
import com.congreso.backend.utils.ApiResponse;
import com.congreso.backend.utils.CustomResponseBuilder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class MenuImplS implements MenuS {
    private final MenuR menuR;
    private final MenuRepo menuRepo;
    private final MesubRepo mesubRepo;
    private final SubmenuRepo submenuRepo;
    private final CustomResponseBuilder customResponseBuilder;

    @Override
    public ResponseEntity<ApiResponse> findAll() {
        List<Menu> menu = menuR.findAll();
        return customResponseBuilder.buildResponse(HttpStatus.OK.value(), "Consulta exitosa.", menu);
    }
    @Override
    public ResponseEntity<ApiResponse> findAll_2(boolean xstatus) {
        List<Menu> menu = menuR.findAll_2(xstatus);
        return customResponseBuilder.buildResponse(HttpStatus.OK.value(), "Consulta exitosa.", menu);
    }

    @Override
    public ResponseEntity<ApiResponse> findAll_SubmenusSinAsignar(int id_menu) {
        MenuE xmenu = menuRepo.findById(id_menu)
                .orElseThrow(() -> new ResourceNotFoundException("El ID. menu","ID. menu",id_menu));
        List<Submenu> submenu = menuR.findAll_SubmenuSinAsignar(id_menu);
        return customResponseBuilder.buildResponse(HttpStatus.OK.value(), "Consulta exitosa.", submenu);
    }

    @Override
    public ResponseEntity<ApiResponse> findAll_SubmenusAsignados(int id_menu) {
        MenuE xmenu = menuRepo.findById(id_menu)
                .orElseThrow(() -> new ResourceNotFoundException("El ID. menu","ID. menu",id_menu));
        List<SubmenuPrivDto> submenu = menuR.findAll_SubmenuAsignados(id_menu);
        return customResponseBuilder.buildResponse(HttpStatus.OK.value(), "Consulta exitosa.", submenu);
    }

    @Override
    public ResponseEntity<ApiResponse> grantMenuSubmenu(MesubDto mesub) {
        MenuE xmenu = menuRepo.findById(mesub.getId_menu())
                .orElseThrow(() -> new ResourceNotFoundException("El ID. menu","ID. menu",mesub.getId_menu()));
        SubmenuE xsubmenu = submenuRepo.findById(mesub.getId_submenu())
                .orElseThrow(() -> new ResourceNotFoundException("El ID. submenu","ID. submenu",mesub.getId_submenu()));
        boolean res = mesubRepo.existsMesub_ByIdMenuAndIdSubm(mesub.getId_menu(),mesub.getId_submenu());
        if (res) {
            throw new DataAlreadyExistsException("Error, la Relación Menu y Submenu ya existe.");
        }
        Long id = menuR.grantMenuSubmenu(mesub);
        return customResponseBuilder.buildResponse(HttpStatus.OK.value(), "Consulta exitosa.", 0);
    }

    @Override
    public ResponseEntity<ApiResponse> revokeMenuSubmenu(int idMesub) {
        MesubE xmesub = mesubRepo.findById(idMesub)
                .orElseThrow(() -> new ResourceNotFoundException("El ID. mesub","ID. mesub",idMesub));
        Boolean res = menuR.revokeMenuSubmenu(idMesub);
        return customResponseBuilder.buildResponse(HttpStatus.OK.value(), "Consulta exitosa.", 0);

    }

    @Override
    public ResponseEntity<ApiResponse> saveMenu(Menu me) {
        Long idmenu = menuR.saveMenu(me);
        return customResponseBuilder.buildResponse(HttpStatus.OK.value(), "Los datos se Guardaron Satisfactoriamente .", null);
    }
    @Override
    public ResponseEntity<ApiResponse> update(Menu me, int id_menu) {
        boolean idmenu = menuR.update(me,id_menu);
        return customResponseBuilder.buildResponse(HttpStatus.OK.value(), "Los datos se Modificaron Satisfactoriamente .", null);
    }

    @Override
    public ResponseEntity<ApiResponse> delete(int id) {
        boolean status = menuR.deleteById(id);
        String mensaje="";
        if (status) {
            mensaje="Se habilitó el Menu satisfactoriamente.";
        }else{
            mensaje="Se eliminó El Menu satisfactoriamente.";
        }
        return customResponseBuilder.buildResponse(HttpStatus.OK.value(), mensaje, 0);
    }
}
