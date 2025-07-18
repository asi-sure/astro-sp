package com.congreso.backend.service.Impl;

import com.congreso.backend.enumeration.Tipo_persons;
import com.congreso.backend.model.Departament;
import com.congreso.backend.model.Person;
import com.congreso.backend.model.Persons;
import com.congreso.backend.model.Role;
import com.congreso.backend.model.dto.PersonsDto;
import com.congreso.backend.repository.PersonsR;
import com.congreso.backend.service.PersonsS;
import com.congreso.backend.utils.ApiResponse;
import com.congreso.backend.utils.CustomResponseBuilder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Service
public class PersonsImplS implements PersonsS {

    private final PersonsR personsR;
    private final CustomResponseBuilder customResponseBuilder;

    @Value("${app.upload.photo-dir}")
    private String photoDirectory;
    @Value("${app.load.photo-dir}")
    private String photoDir;
    @Value("${app.default.photo}")
    private String fileNameDefault;

    @Override
    public ResponseEntity<ApiResponse> findAll(boolean xstatus, Tipo_persons tipoper) {
        List<PersonsDto> persons = personsR.findAll(xstatus, tipoper);
        return customResponseBuilder.buildResponse(HttpStatus.OK.value(), "Consulta exitosa.", persons);
    }

    @Override
    public ResponseEntity<ApiResponse> findById(int id) {
        Persons persons = personsR.findById(id);
        List<Role> role = personsR.roleFindById(id);
        return customResponseBuilder.buildResponse(HttpStatus.OK.value(), "Búsqueda exitosa.", persons, role,null);
    }

    @Override
    public ResponseEntity<ApiResponse> delete(int id) {
        boolean status = personsR.delete(id);
        String mensaje="";
        if (status) {
            mensaje="Se habilitó satisfactoriamente.";
        }else{
            mensaje="Se eliminó satisfactoriamente.";
        }
        return customResponseBuilder.buildResponse(HttpStatus.OK.value(), mensaje, 0);
    }
    @Override
    public ResponseEntity<ApiResponse> savePersons(Persons person, MultipartFile file) {
        if (personsR.verificarCedula(person.getCedula(),0)) {
            return customResponseBuilder.buildResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), "La Cédula ya Existe.", 0);
        }
        String fileName=fileNameDefault;
        if (!file.isEmpty()) {  //si hay imagen
            fileName = generateUniqueFileName(file);
        }
        person.setPhoto(photoDir + fileName);

        try {
            Long idper = personsR.savePersons(person);

            if (!file.isEmpty()) {
                // Crear el directorio de uploads si no existe
                File uploadDir = new File(photoDirectory);
                if (!uploadDir.exists()) {
                    uploadDir.mkdirs();
                }
                // Definir la ruta completa donde se guardará el archivo
                Path filePath = Paths.get(photoDirectory + fileName);
                // Guardar el archivo en el sistema de archivos
                Files.copy(file.getInputStream(), filePath);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return customResponseBuilder.buildResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error al subir archivo.", 0);
        }
        return customResponseBuilder.buildResponse(HttpStatus.OK.value(), "Consulta exitosa.", null);
    }
    @Override
    public ResponseEntity<ApiResponse> update(Persons obj, MultipartFile file, int id) {
        if (personsR.verificarCedula(obj.getCedula(),id)) {
            return customResponseBuilder.buildResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), "La Cédula ya Existe.", 0);
        }
        String fileName="-"; //si es '-' no actulizará foto
        if (!file.isEmpty()) {  //si hay imagen
            fileName = generateUniqueFileName(file);
            obj.setPhoto(photoDir + fileName);
        }else{
            obj.setPhoto(fileName);
        }
        boolean updated = personsR.update(obj, id);
        if (!updated) {
            return customResponseBuilder.buildResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error al Guardar los datos.", 0);
        }
        try {
            if (!file.isEmpty()) {
                // Crear el directorio de uploads si no existe
                File uploadDir = new File(photoDirectory);
                if (!uploadDir.exists()) {
                    uploadDir.mkdirs();
                }
                // Definir la ruta completa donde se guardará el archivo
                Path filePath = Paths.get(photoDirectory + fileName);
                // Guardar el archivo en el sistema de archivos
                Files.copy(file.getInputStream(), filePath);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return customResponseBuilder.buildResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error al subir archivo.", updated);
        }
        return customResponseBuilder.buildResponse(HttpStatus.OK.value(), "Actualizacion exitosa.", updated);
    }

    @Override
    public ResponseEntity<ApiResponse> updateTipoper(Tipo_persons tipoper, int id) {
        boolean updated = personsR.updateTipoper(tipoper, id);
        if (!updated) {
            return customResponseBuilder.buildResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error al Guardar Tipo de Persona.", 0);
        }
        return customResponseBuilder.buildResponse(HttpStatus.OK.value(), "Actualizacion exitosa.", updated);
    }

    public static String generateUniqueFileName(MultipartFile file) {
        String originalFileName = file.getOriginalFilename();
        String fileExtension = "";
        int dotIndex = originalFileName.lastIndexOf('.');
        if (dotIndex > 0 && dotIndex < originalFileName.length() - 1) {
            fileExtension = originalFileName.substring(dotIndex); // Includes the dot, e.g., ".jpg"
        }

        long timestamp = LocalDateTime.now().toInstant(ZoneOffset.UTC).toEpochMilli();
        String uuid = UUID.randomUUID().toString();

        return timestamp + "_" + uuid + fileExtension;
    }
/*    @Override
    public ResponseEntity<ApiResponse> savePersons(Persons person, MultipartFile file) {
        Long idper = personsR.savePersons(person);
        return customResponseBuilder.buildResponse(HttpStatus.OK.value(), "Consulta exitosa.", idper);
    }*/
    /*
        @Override
    public ResponseEntity<ApiResponse> save(Person person, MultipartFile file) {
        Long isCreated = personR.save(person);
        return customResponseBuilder.buildResponse(HttpStatus.OK.value(), "Consulta exitosa.", isCreated);
    }
     */
}
