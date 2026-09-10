package com.congreso.backend.service;

import com.congreso.backend.model.Menu;
import com.congreso.backend.utils.ApiResponse;
import org.springframework.http.ResponseEntity;

public interface PrivilegiosS {
    ResponseEntity<ApiResponse> findAll();
    ResponseEntity<ApiResponse> findByIdmenuIdsubm(int idMenu, int idSubm);
    ResponseEntity<ApiResponse> savePrivMenu(int id_mesub, int id_priv);

    ResponseEntity<ApiResponse> delete_PrivMenu(int idPrivMenu);
//    ResponseEntity<ApiResponse> findAllSubmenu_Privilegios();
//    ResponseEntity<ApiResponse> findBySubmenuId(int id_submenu);

}
