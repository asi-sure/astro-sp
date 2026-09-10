package com.congreso.backend.controller.Impl;

import com.congreso.backend.controller.PrivilegiosC;
import com.congreso.backend.entities.PrivilegiosE;
import com.congreso.backend.service.PrivilegiosS;
import com.congreso.backend.utils.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @Override
    @GetMapping("privilegios/menu/submenu")
    public ResponseEntity<ApiResponse> findByIdmenuIdsubm(@RequestParam(name = "idMenu") int idMenu,
                                                          @RequestParam(name = "idSubm") int idSubm) {
        return privilegiosS.findByIdmenuIdsubm(idMenu,idSubm);
    }
    @Override
    @PostMapping("privilegios/priv_menu")
    public ResponseEntity<ApiResponse> save_PrivMenu(
                @RequestParam(name = "id_mesub") int id_mesub,
                @RequestParam(name = "id_priv") int id_priv) {
        return privilegiosS.savePrivMenu(id_mesub, id_priv);
    }

    @Override
    @DeleteMapping("privilegios/priv_menu/{id_priv_menu}")
    public ResponseEntity<ApiResponse> delete_PrivMenu(@PathVariable int id_priv_menu) {
        return privilegiosS.delete_PrivMenu(id_priv_menu);
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
