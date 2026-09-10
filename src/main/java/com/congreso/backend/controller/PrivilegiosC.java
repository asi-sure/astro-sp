package com.congreso.backend.controller;

import com.congreso.backend.entities.PrivilegiosE;
import com.congreso.backend.model.Menu;
import com.congreso.backend.utils.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface PrivilegiosC {
    public ResponseEntity<ApiResponse> findAll();
    public ResponseEntity<ApiResponse> findByIdmenuIdsubm(int idMenu, int idSubm);
    ResponseEntity<ApiResponse> save_PrivMenu(int id_mesub, int id_priv);
    ResponseEntity<ApiResponse> delete_PrivMenu(int idPrivMenu);

}
