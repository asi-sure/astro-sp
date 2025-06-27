package com.congreso.backend.controller.Impl;

import com.congreso.backend.controller.PersonsC;
import com.congreso.backend.model.Persons;
import com.congreso.backend.service.PersonsS;
import com.congreso.backend.utils.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/")
@PreAuthorize("hasRole('ADMINISTRADOR')")
public class PersonsImplC implements PersonsC {

    private final PersonsS personsS;

    @Override
    @GetMapping("persons/{xstatus}")
    public ResponseEntity<ApiResponse> findAll(@PathVariable boolean xstatus) {
        return personsS.findAll(xstatus);
    }
    @Override
    @GetMapping("persons/id/{xid}")
    public ResponseEntity<ApiResponse> findById(@PathVariable int xid) {
//        int id=Integer.parseInt(xid);
        return personsS.findById(xid);
    }
    @Override
    @DeleteMapping("persons/{xid}")
    public ResponseEntity<ApiResponse> delete(@PathVariable int xid) {
        return personsS.delete(xid);
    }
    @Override
    @PostMapping("persons")
    public ResponseEntity<ApiResponse> save(
            @RequestPart("person") Persons person,
            @RequestPart("file") MultipartFile file) {
        return personsS.savePersons(person, file);
    }
    @Override
    @PutMapping("persons/{id}")
    public ResponseEntity<ApiResponse> update(
            @RequestPart("person") Persons person,
            @RequestPart("file") MultipartFile file,
            @PathVariable int id
    ) {
        return personsS.update(person, file, id);
    }

//    @Override
//    @PostMapping("persons/upload")
//    public String upload(@RequestParam("file") MultipartFile file) {
//        String UPLOAD_DIR = "src/main/resources/static/images/photos/";
//
//        if (file.isEmpty()) {
//            return ("Por favor selecciona un archivo para subir.");
//        }
//
//        try {
//            // Crear el directorio de uploads si no existe
//            File uploadDir = new File(UPLOAD_DIR);
//            if (!uploadDir.exists()) {
//                uploadDir.mkdirs();
//            }
//
//            // Obtener el nombre del archivo
//            String fileName = file.getOriginalFilename();
//            // Definir la ruta completa donde se guardará el archivo
//            Path filePath = Paths.get(UPLOAD_DIR + fileName);
//
//            // Guardar el archivo en el sistema de archivos
//            Files.copy(file.getInputStream(), filePath);
//
//            return ("Archivo '" + fileName + "' subido exitosamente.");
//
//        } catch (IOException e) {
//            e.printStackTrace();
//            return ("Error al subir el archivo: " );
//        }
//    }

/*    @Override
    public ResponseEntity<ApiResponse> save(Persons person, MultipartFile file) {
        return personsS.savePersons(person);
    }*/

    /*    @PostMapping("post")
    @PreAuthorize("hasAuthority('CREATE')")
    public ResponseEntity<ApiResponse> post(@RequestBody Person person) {
        return personS.save(person);
    }*/


}
