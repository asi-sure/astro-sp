package com.congreso.backend.controller.Impl;

import com.congreso.backend.controller.PrivilegiosC;
import com.congreso.backend.entities.PrivilegiosE;
import com.congreso.backend.service.PrivilegiosS;
import com.congreso.backend.utils.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/")
public class PrivilegiosImplC implements PrivilegiosC {
    private final PrivilegiosS privilegiosS;

    @Override
    @GetMapping("privilegios")
    public ResponseEntity<ApiResponse> findAll() {
        return privilegiosS.findAll();
    }

//    @Override
//    @GetMapping("submenu-privilegios")
//    public ResponseEntity<ApiResponse> findAllSubmenu_Privilegios() {
//        return privilegiosS.findAllSubmenu_Privilegios();
//    }
//
//    @Override
//    @GetMapping("submenu-privilegios/{id_submenu}")
//    public ResponseEntity<ApiResponse> findSumenuById(@PathVariable int id_submenu) {
//        return privilegiosS.findBySubmenuId(id_submenu);
//    }
}
