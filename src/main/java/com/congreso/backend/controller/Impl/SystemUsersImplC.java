package com.congreso.backend.controller.Impl;

import com.congreso.backend.controller.SystemUsersC;
import com.congreso.backend.model.Persons;
import com.congreso.backend.model.SystemUsers;
import com.congreso.backend.model.dto.SystemUsersDto;
import com.congreso.backend.service.PersonsS;
import com.congreso.backend.service.SystemUsersS;
import com.congreso.backend.utils.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/")
//@PreAuthorize("hasRole('ADMINISTRADOR')")
public class SystemUsersImplC implements SystemUsersC {
    private final SystemUsersS userS;
//    @Override
    @PostMapping("systemusers")
    public ResponseEntity<ApiResponse> save(@RequestBody SystemUsersDto user) {
        return userS.save(user);
    }
}
