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
    @GetMapping("menu/{xstatus}")
    @Override
    public ResponseEntity<ApiResponse> findAll_2(@PathVariable boolean xstatus) {
        return menuS.findAll_2(xstatus);
    }
    @PostMapping("menu")
    @Override
    public ResponseEntity<ApiResponse> save(Menu menu) {
        return menuS.saveMenu(menu);
    }



}
