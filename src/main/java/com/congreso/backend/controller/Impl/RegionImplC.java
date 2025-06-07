package com.congreso.backend.controller.Impl;

import com.congreso.backend.controller.RegionC;
import com.congreso.backend.model.Region;
import com.congreso.backend.service.RegionS;
import com.congreso.backend.utils.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/region/")
@PreAuthorize("hasAnyRole('ADMINISTRADOR','PROFESOR')")
public class RegionImplC implements RegionC {
    private final RegionS regionS;

/*    @Override
    @GetMapping("findAll")
    public ResponseEntity<ApiResponse> findAll() {
        return regionS.findAll();
    }*/

/*    @Override
    @GetMapping("findById/{id}")
    public ResponseEntity<ApiResponse> findById(@PathVariable Integer id) {
        return regionS.findById(id);
    }*/

/*    @Override
    @PostMapping("save")
    public ResponseEntity<ApiResponse> save(@RequestBody Region region) {
        return regionS.save(region);
    }*/

/*    @Override
    @PutMapping("update/{id}")
    public ResponseEntity<ApiResponse> update(@RequestBody Region obj, @PathVariable Integer id) {
        return regionS.update(obj, id);
    }*/

/*    @Override
    @PutMapping("deleteById")
    public ResponseEntity<ApiResponse> deleteById(@PathVariable Integer id) {
        return regionS.deleteById(id);
    }*/

}
