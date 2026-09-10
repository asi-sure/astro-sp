package com.congreso.backend.service.Impl;

import com.congreso.backend.entities.Dto.PrivilegiosDto;
import com.congreso.backend.entities.MesubE;
import com.congreso.backend.entities.Priv_MenuE;
import com.congreso.backend.entities.PrivilegiosE;
import com.congreso.backend.exception.type.DataAlreadyExistsException;
import com.congreso.backend.exception.type.ResourceNotFoundException;
import com.congreso.backend.repositoryE.MesubRepo;
import com.congreso.backend.repositoryE.Priv_MenuRepo;
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
    private final Priv_MenuRepo privmenuRepo;
    private final MesubRepo mesubRepo;
    private final CustomResponseBuilder customResponseBuilder;

    @Override
    public ResponseEntity<ApiResponse> findAll() {
        List<PrivilegiosE> privilegios = privilegiosRepo.findAll();
        return customResponseBuilder.buildResponse(HttpStatus.OK.value(), "Lista privilegios..!", privilegios);
    }

    @Override
    public ResponseEntity<ApiResponse> findByIdmenuIdsubm(int idMenu, int idSubm) {
        List<PrivilegiosDto> privilegios = privilegiosRepo.findByMenuIdNative(idMenu, idSubm);
        return customResponseBuilder.buildResponse(HttpStatus.OK.value(), "Lista privilegios asignados..!", privilegios);
    }

    @Override
    public ResponseEntity<ApiResponse> savePrivMenu(int id_mesub, int id_priv) {
        MesubE res1 = mesubRepo.findById(id_mesub)
                .orElseThrow(() -> new ResourceNotFoundException("El ID. id_mesub","ID. mesub",id_mesub));
        PrivilegiosE res2 = privilegiosRepo.findById(id_priv)
                .orElseThrow(() -> new ResourceNotFoundException("El ID. id_priv","ID. priv",id_priv));
        if (res1.getId_menu()>0 && res2.getId_priv()>0){
            throw new DataAlreadyExistsException("El privilegio ya se encuentra asignado a este submenú.");
        }
        int idprivMenu = privmenuRepo.add_privMenu(id_mesub, id_priv);
        return customResponseBuilder.buildResponse(HttpStatus.OK.value(), "Los datos se Guardaron Satisfactoriamente .", null);
    }

    @Override
    public ResponseEntity<ApiResponse> delete_PrivMenu(int idPrivMenu) {
        Priv_MenuE res = privmenuRepo.findById(idPrivMenu)
                .orElseThrow(() -> new ResourceNotFoundException("El ID. id_priv_menu","ID. id_priv_menu",idPrivMenu));

        int status = privmenuRepo.del_privMenu(idPrivMenu);
        String mensaje="";
        if (status==1) {
            mensaje="Se Eliminó el Privilegio satisfactoriamente.";
        }
        return customResponseBuilder.buildResponse(HttpStatus.OK.value(), mensaje, 0);
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
