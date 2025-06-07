package com.congreso.backend.controller.Impl;

import com.congreso.backend.controller.DepartamentC;
import com.congreso.backend.model.Departament;
import com.congreso.backend.service.DepartamentS;
import com.congreso.backend.utils.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/departament/")
@PreAuthorize("hasAnyRole('ADMINISTRADOR','PROFESOR')")
public class DepartamentImplC implements DepartamentC {
    private final DepartamentS departamentS;

/*    @Override
    @GetMapping("findAll")
    public ResponseEntity<ApiResponse> findAll() {
        return departamentS.findAll();
    }*/

/*    @Override
    @GetMapping("findById/{id}")
    public ResponseEntity<ApiResponse> findById(Integer id) {
        return departamentS.findById(id);
    }*/

/*    @Override
    @PostMapping("save")
    public ResponseEntity<ApiResponse> save(@RequestBody Departament obj) {
        return departamentS.save(obj);
    }*/

/*    @Override
    @PutMapping("update/{id}")
    public ResponseEntity<ApiResponse> update(@RequestBody Departament obj, @PathVariable Integer id) {
        return departamentS.update(obj, id);
    }*/

/*    @Override
    @PutMapping("deleteById/{id}")
    public ResponseEntity<ApiResponse> deleteById(@PathVariable Integer id) {
        return departamentS.deleteById(id);
    }*/

}
