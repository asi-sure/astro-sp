package com.congreso.backend.controller.Impl;

import com.congreso.backend.controller.PersonC;
import com.congreso.backend.model.Person;
import com.congreso.backend.service.PersonS;
import com.congreso.backend.utils.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/person/")
@PreAuthorize("hasRole('ADMINISTRADOR')")
public class PersonImplC implements PersonC {
    private final PersonS personS;

//    @Override
//    @GetMapping("get")
//    @PreAuthorize("permitAll()")
//    public ResponseEntity<ApiResponse> findAll() {
//        return personS.findAll();
//    }

/*    @PostMapping("post")
    @PreAuthorize("hasAuthority('CREATE')")
    public ResponseEntity<ApiResponse> post(@RequestBody Person person) {
        return personS.save(person);
    }*/

//    @Override
//    @GetMapping("get/{id}")
////    @PreAuthorize("hasAuthority('CREATE')")
//    @PreAuthorize("permitAll()")
//    public ResponseEntity<ApiResponse> findById(@PathVariable Long id) {
//        return personS.getById(id);
//    }


/*    @Override
    @PutMapping("put/{id}")
    @PreAuthorize("hasAuthority('PUT')")
    public ResponseEntity<ApiResponse> update(@Valid @RequestBody Person person, @PathVariable Long id) {
        return personS.update(person, id);
    }*/

/*    @Override
    @PutMapping("delete/{id}")
    @PreAuthorize("hasAuthority('DELETE')")
    public ResponseEntity<ApiResponse> deleteById(@PathVariable Long id) {
        return personS.deleteById(id);
    }*/
}
