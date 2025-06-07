package com.congreso.backend.controller.Impl;

import com.congreso.backend.controller.TeamC;
import com.congreso.backend.model.Team;
import com.congreso.backend.service.TeamS;
import com.congreso.backend.utils.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/team/")
@PreAuthorize("hasAnyRole('ADMINISTRADOR','PROFESOR')")
public class TeamImplC implements TeamC {
    private final TeamS teamS;

    /*@Override
    @GetMapping("findAll")
    public ResponseEntity<ApiResponse> findAll() {
        return teamS.findAll();
    }*/

    /*@Override
    @GetMapping("findById/{id}")
    public ResponseEntity<ApiResponse> findById(@PathVariable int id) {
        return teamS.findById(id);
    }*/

    /*@Override
    @PostMapping("save")
    public ResponseEntity<ApiResponse> save(@RequestBody Team team) {
        return teamS.save(team);
    }*/

/*    @Override
    @PutMapping("update/{id}")
    public ResponseEntity<ApiResponse> update(@PathVariable int id, @RequestBody Team obj) {
        return teamS.update(obj, id);
    }*/

/*    @Override
    @PutMapping("deleteById/{id}")
    public ResponseEntity<ApiResponse> deleteById(@PathVariable int id) {
        return teamS.deleteById(id);
    }*/
}
