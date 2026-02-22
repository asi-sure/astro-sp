package com.congreso.backend.service;

import com.congreso.backend.utils.ApiResponse;
import org.springframework.http.ResponseEntity;

public interface PrivilegiosS {
    ResponseEntity<ApiResponse> findAll();
//    ResponseEntity<ApiResponse> findAllSubmenu_Privilegios();
//    ResponseEntity<ApiResponse> findBySubmenuId(int id_submenu);

}
