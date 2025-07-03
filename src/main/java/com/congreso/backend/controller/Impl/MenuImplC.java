package com.congreso.backend.controller.Impl;

import com.congreso.backend.controller.MenuC;
import com.congreso.backend.model.Menu;
import com.congreso.backend.model.Persons;
import com.congreso.backend.service.DepartamentS;
import com.congreso.backend.service.MenuS;
import com.congreso.backend.utils.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/")
@PreAuthorize("hasAnyRole('ADMINISTRADOR')")
public class MenuImplC implements MenuC {
    private final MenuS menuS;
    @Override
    @GetMapping("menu/{xstatus}")
    public ResponseEntity<ApiResponse> findAll_2(@PathVariable boolean xstatus) {
        return menuS.findAll_2(xstatus);
    }
    @Override
    @PostMapping("menu")
    public ResponseEntity<ApiResponse> save(@RequestBody Menu menu) {
        return menuS.saveMenu(menu);
    }
    @Override
    @PutMapping("menu/{id_menu}")
    public ResponseEntity<ApiResponse> update(@RequestBody Menu me, @PathVariable int id_menu) {
        return menuS.update(me,id_menu);
    }
    @Override
    @DeleteMapping("menu/{id_menu}")
    public ResponseEntity<ApiResponse> delete(@PathVariable int id_menu) {
        return menuS.delete(id_menu);
    }


}
