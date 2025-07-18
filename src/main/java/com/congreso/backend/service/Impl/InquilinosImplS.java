package com.congreso.backend.service.Impl;

import com.congreso.backend.model.forms.InquilinosForm;
import com.congreso.backend.repository.InquilinosR;
import com.congreso.backend.service.InquilinosS;
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
public class InquilinosImplS implements InquilinosS {
    private final InquilinosR inquilinosR;
    private final CustomResponseBuilder customResponseBuilder;
    @Value("${app.upload.photo-dir}")
    private String photoDirectory;
    @Value("${app.load.photo-dir}")
    private String photoDir;
    @Value("${app.default.photo}")
    private String fileNameDefault;

    @Override
    public ResponseEntity<ApiResponse> findAll(boolean xestado) {
        List<InquilinosForm> inquilinos = inquilinosR.findAll(xestado);
        return customResponseBuilder.buildResponse(HttpStatus.OK.value(), "Consulta exitosa.", inquilinos);
    }
    @Override
    public ResponseEntity<ApiResponse> save(InquilinosForm obj, MultipartFile file) {
        if (inquilinosR.verificarCedula(obj.getCedula(),0)) {
            return customResponseBuilder.buildResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), "La Cédula ya Existe.", 0);
        }
        String fileName=fileNameDefault;
        if (!file.isEmpty()) {  //si hay imagen
            fileName = generateUniqueFileName(file);
        }
        obj.setUbicacion(photoDir + fileName);
        try {
            Long id = inquilinosR.save(obj);

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
    public ResponseEntity<ApiResponse> update(InquilinosForm obj, MultipartFile file, int id) {
        if (inquilinosR.verificarCedula(obj.getCedula(),id)) {
            return customResponseBuilder.buildResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), "La Cédula ya Existe.", 0);
        }
        String fileName="-"; //si es '-' no actulizará foto
        if (!file.isEmpty()) {  //si hay imagen
            fileName = generateUniqueFileName(file);
            obj.setUbicacion(photoDir + fileName);
        }else{
            obj.setUbicacion(fileName);
        }
        boolean updated = inquilinosR.update(obj, id);
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
    public ResponseEntity<ApiResponse> delete(int id) {
        boolean status = inquilinosR.delete(id);
        String mensaje="";
        if (status) {
            mensaje="Se habilitó satisfactoriamente.";
        }else{
            mensaje="Se eliminó satisfactoriamente.";
        }
        return customResponseBuilder.buildResponse(HttpStatus.OK.value(), mensaje, 0);
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
} //the end
