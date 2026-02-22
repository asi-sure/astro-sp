package com.congreso.backend.controller.Impl;

import com.congreso.backend.controller.AuthenticacionC;
import com.congreso.backend.controller.request.AuthLoginRequest;
import com.congreso.backend.model.Persons;
import com.congreso.backend.model.dto.MenusDto;
import com.congreso.backend.model.dto.PrivilegiosDto;
import com.congreso.backend.model.dto.RoleDto;
import com.congreso.backend.model.dto.SubmenuDto;
import com.congreso.backend.repository.MenuR;
import com.congreso.backend.repository.PersonR;
import com.congreso.backend.repository.RoleR;
import com.congreso.backend.service.SystemsUserS;
import com.congreso.backend.utils.ApiResponse;
import com.congreso.backend.utils.*;
import com.congreso.backend.utils.AuthResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequiredArgsConstructor
@RequestMapping("/auth/")
public class AuthenticationImplC implements AuthenticacionC {
    private static final Logger logger = LoggerFactory.getLogger(AuthenticationImplC.class);
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
//        List<MenuDto> menu = menuR.findByPerson(person.getId());

        Map<String, Object> hashMap = new HashMap<>();
        hashMap.put("id", person.getId());
        hashMap.put("token", ar.jwt());
        hashMap.put("username", ar.username());
        hashMap.put("user", person.getName()+" "+person.getFirstName()+" "+person.getSecondName());
        hashMap.put("cedula", person.getCedula());
        hashMap.put("email", person.getEmail());
        hashMap.put("photo", urlServer+person.getPhoto());
        hashMap.put("fecha", LocalDate.now());
//        hashMap.put("rol", role.getName());
//        MenusDto = obtenerMenuSubmenu(person.getId());
        return customResponseBuilder.buildResponse(HttpStatus.OK.value(), ar.message(),obtenerMenuSubmenu(person.getId()),role,hashMap);
    }

    public List<MenusDto> obtenerMenuSubmenu(Long id_person){
        //paso 1 y 2 : descargar de la base de datos
        List<MenusDto> menu = menuR.findMenuByPerson(id_person);
        List<SubmenuDto> submenuDto = menuR.findSubmenuByPerson(id_person);
        List<PrivilegiosDto> privilegiosDto = menuR.findPrivilegiosByPerson(id_person);

        // 2. Agrupar PRIVILEGIOS por id_subm (Hijos de Submenú)
        Map<Integer, List<PrivilegiosDto>> privilegiosPorSubmenu = new HashMap<>();
        for (PrivilegiosDto priv : privilegiosDto) {
            privilegiosPorSubmenu
                    .computeIfAbsent(priv.getId_subm(), k -> new ArrayList<>())
                    .add(new PrivilegiosDto(priv.getId_subm(), priv.getId_priv(), priv.getAlias(), priv.getDescription()));
        }
        // 3. Agrupar SUBMENÚS por id_menu (Hijos de Menú)
        Map<Integer, List<SubmenuDto>> submenusPorMenu = new HashMap<>();
        for (SubmenuDto sub : submenuDto) {
            // BUSCAMOS LOS PRIVILEGIOS DE ESTE SUBMENÚ
            List<PrivilegiosDto> privsDeEsteSub = privilegiosPorSubmenu.getOrDefault(sub.getId_subm(), new ArrayList<>());

            // CREAMOS EL SUBMENÚ CON SUS PRIVILEGIOS ADENTRO
            submenusPorMenu
                    .computeIfAbsent(sub.getId_menu(), k -> new ArrayList<>())
                    .add(new SubmenuDto(
                            sub.getId_menu(),
                            sub.getId_subm(),
                            sub.getName(),
                            sub.getDescription(),
                            sub.getLink(),
                            privsDeEsteSub // <--- CONEXIÓN CRÍTICA
                    ));
        }
        // 4. Crear la lista final de MENÚS (Padres)
        List<MenusDto> padresDTO = new ArrayList<>();
        for (MenusDto padre : menu) {
            // BUSCAMOS LOS SUBMENÚS DE ESTE MENÚ
            List<SubmenuDto> subDeEstePadre = submenusPorMenu.getOrDefault(padre.getId_menu(), new ArrayList<>());

            // CREAMOS EL MENÚ CON SUS SUBMENÚS ADENTRO
            padresDTO.add(new MenusDto(
                    padre.getId_role(),
                    padre.getId_menu(),
                    padre.getName(),
                    padre.getDescription(),
                    padre.getType_menu(),
                    padre.getIcon(),
                    subDeEstePadre // <--- CONEXIÓN CRÍTICA
            ));
        }

//        System.out.println(padresDTO);
        logger.info("Menú generado para usuario: {}", id_person);
        return padresDTO;
    }


}
