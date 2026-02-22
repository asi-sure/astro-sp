package com.congreso.backend.service.Impl;

import com.congreso.backend.entities.PrivilegiosE;
import com.congreso.backend.repositoryE.PrivilegiosRepo;
import com.congreso.backend.service.PrivilegiosS;
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
public class PrivilegiosImplS implements PrivilegiosS {
    private final PrivilegiosRepo privilegiosRepo;
    private final CustomResponseBuilder customResponseBuilder;

    @Override
    public ResponseEntity<ApiResponse> findAll() {
        List<PrivilegiosE> privilegios = privilegiosRepo.findAll();
        return customResponseBuilder.buildResponse(HttpStatus.OK.value(), "Lista privilegios..!", privilegios);
    }

//    @Override
//    public ResponseEntity<ApiResponse> findAllSubmenu_Privilegios() {
//        List<SubPriE> subpri = subpriRepo.findAll();
//        return customResponseBuilder.buildResponse(HttpStatus.OK.value(), "Lista submenus y privilegios..!", subpri);
//    }

//    @Override
//    public ResponseEntity<ApiResponse> findBySubmenuId(int id_submenu) {
//        List<SubPriE> subpri = subpriRepo.encontrarSubmenuId(id_submenu);
//        return customResponseBuilder.buildResponse(HttpStatus.OK.value(), "Lista submenus y privilegios..!", subpri);
//    }
}
