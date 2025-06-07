package com.congreso.backend.controller.Impl;

import com.congreso.backend.controller.AuthenticacionC;
import com.congreso.backend.controller.request.AuthCreateUserRequest;
import com.congreso.backend.controller.request.AuthLoginRequest;
import com.congreso.backend.model.Persons;
import com.congreso.backend.model.Role;
import com.congreso.backend.model.Submenu;
import com.congreso.backend.model.dto.MenuDto;
import com.congreso.backend.model.dto.MenusDto;
import com.congreso.backend.model.dto.RoleDto;
import com.congreso.backend.model.dto.SubmenuDto;
import com.congreso.backend.repository.MenuR;
import com.congreso.backend.repository.PersonR;
import com.congreso.backend.repository.RoleR;
import com.congreso.backend.service.PersonS;
import com.congreso.backend.service.RoleS;
import com.congreso.backend.service.SystemsUserS;
import com.congreso.backend.utils.ApiResponse;
import com.congreso.backend.utils.*;
import com.congreso.backend.utils.AuthResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequiredArgsConstructor
@RequestMapping("/auth/")
public class AuthenticationImplC implements AuthenticacionC {
    private final SystemsUserS systemsUserS;
    private final RoleR roleR;
    private final PersonR personR;
    private final MenuR menuR;
    private final CustomResponseBuilder customResponseBuilder;

    @Value("${backend.url}")
    private String urlServer;
/*    @Override
    @PostMapping("sign-up")
    public ResponseEntity<AuthResponse> register(@RequestBody @Valid AuthCreateUserRequest authCreateUser) {
        return new ResponseEntity<>(systemsUserS.createUser(authCreateUser), HttpStatus.CREATED);
    }*/

/*    @Override
    @PostMapping("log-in")
    public ResponseEntity<AuthResponse> login(@RequestBody @Valid AuthLoginRequest userRequest) {
        return new ResponseEntity<AuthResponse>(systemsUserS.loginUser(userRequest), HttpStatus.OK);
    }*/

    @Override
    @PostMapping("log-in")
    public ResponseEntity<ApiResponse> login(@RequestBody @Valid AuthLoginRequest userRequest) {
        AuthResponse ar = systemsUserS.loginUser(userRequest);
        Persons person = personR.getById2(userRequest.username());
        List<RoleDto> role = roleR.findByPerson(person.getId());
        List<MenuDto> menu = menuR.findByPerson(person.getId());

        Map<String, Object> hashMap = new HashMap<>();
        hashMap.put("token", ar.jwt());
        hashMap.put("username", ar.username());
        hashMap.put("user", person.getName()+" "+person.getFirstName()+" "+person.getSecondName());
        hashMap.put("cedula", person.getCedula());
        hashMap.put("email", person.getEmail());
        hashMap.put("photo", urlServer+person.getPhoto());
//        hashMap.put("rol", role.getName());
//        MenusDto = obtenerMenuSubmenu(person.getId());
        return customResponseBuilder.buildResponse(HttpStatus.OK.value(), ar.message(),obtenerMenuSubmenu(person.getId()),role,hashMap);
    }

    public List<MenusDto> obtenerMenuSubmenu(Long id_person){
        //paso 1 y 2 : descargar de la base de datos
        List<MenusDto> menu = menuR.findMenuByPerson(id_person);
        List<SubmenuDto> submenuDto = menuR.findSubmenuByPerson(id_person);
        // Paso 3: Agrupar los hijos por id_padre
        Map<Integer, List<SubmenuDto>> hijosPorPadre = new HashMap<>();
        for (SubmenuDto hijo : submenuDto) {
            hijosPorPadre.computeIfAbsent(hijo.getId_menu(), k -> new ArrayList<>())
                    .add(new SubmenuDto(hijo.getId_menu(),hijo.getId_subm(), hijo.getName(), hijo.getDescription(), hijo.getLink()));
        }
        // Paso 4: Crear la lista de DTOs de ClasePadre
        List<MenusDto> padresDTO = new ArrayList<>();
        for (MenusDto padre : menu) {
            List<SubmenuDto> hijosDeEstePadre = hijosPorPadre.getOrDefault(padre.getId_menu(), new ArrayList<>());
            padresDTO.add(new MenusDto(padre.getId_role(),padre.getId_menu(), padre.getName(), padre.getDescription(),padre.getType_menu(),padre.getIcon(), hijosDeEstePadre));
        }
        System.out.println(padresDTO);
        return padresDTO;
    }


}
