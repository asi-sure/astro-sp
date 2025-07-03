package com.congreso.backend.service;

import com.congreso.backend.model.Menu;
import com.congreso.backend.model.Persons;
import com.congreso.backend.utils.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface MenuS {

    ResponseEntity<ApiResponse> findAll();
    ResponseEntity<ApiResponse> findAll_2(boolean xstatus);
    ResponseEntity<ApiResponse> saveMenu(Menu me);
    ResponseEntity<ApiResponse> update(Menu me, int id_menu);
    ResponseEntity<ApiResponse> delete(int id);

}
