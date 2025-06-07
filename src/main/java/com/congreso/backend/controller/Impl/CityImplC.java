package com.congreso.backend.controller.Impl;

import com.congreso.backend.model.City;
import com.congreso.backend.service.CityS;
import com.congreso.backend.utils.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/city/")
@PreAuthorize("hasAnyRole('ADMINISTRADOR','PROFESOR')")
public class CityImplC {
    private final CityS cityS;

/*    @GetMapping("findAll")
    public ResponseEntity<ApiResponse> findAll() {
        return cityS.findAll();
    }*/

/*    @GetMapping("findById/{id}")
    public ResponseEntity<ApiResponse> findById(@PathVariable Long id) {
        return cityS.findById(id);
    }*/

/*    @PostMapping("save")
    public ResponseEntity<ApiResponse> save(@RequestBody City obj) {
        return cityS.save(obj);
    }*/

/*    @PutMapping("update/{id}")
    public ResponseEntity<ApiResponse> update(@PathVariable Long id, @RequestBody City obj) {
        return cityS.update(obj, id);
    }*/

/*    @PutMapping("deleteById/{id}")
    public ResponseEntity<ApiResponse> deleteById(@PathVariable Long id) {
        return cityS.deleteById(id);
    }*/
}
