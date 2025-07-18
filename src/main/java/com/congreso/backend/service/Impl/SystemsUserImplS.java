package com.congreso.backend.service.Impl;

import com.congreso.backend.config.security.jwt.JwtUtils;
import com.congreso.backend.controller.request.AuthCreateUserRequest;
import com.congreso.backend.controller.request.AuthLoginRequest;
import com.congreso.backend.model.*;
import com.congreso.backend.repository.PersonR;
import com.congreso.backend.repository.RoleR;
import com.congreso.backend.repository.SystemUserR;
import com.congreso.backend.service.SystemsUserS;
import com.congreso.backend.utils.ApiResponse;
import com.congreso.backend.utils.AuthResponse;
import com.congreso.backend.utils.CustomResponseBuilder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class SystemsUserImplS implements SystemsUserS {
    private final SystemUserR systemUserR;
    private final RoleR roleR;
    private final PersonR personR;
    private final JwtUtils jwtUtils;
    private final PasswordEncoder passwordEncoder;
    private final CustomResponseBuilder customResponseBuilder;
    private final UserDetailServiceImplS userDetailServiceImplS;

    @Override
    public ResponseEntity<ApiResponse> findAll() {
        List<SystemUser> systemUsers = systemUserR.findAll();
        return customResponseBuilder.buildResponse(HttpStatus.OK.value(), "Consulta exitosa.", systemUsers);
    }

    @Override
    public SystemUser findById(Long id) {
      return systemUserR.findById(id);

    }

    @Override
    public AuthResponse loginUser(AuthLoginRequest authLoginRequest) {
        String username = authLoginRequest.username();
        String password = authLoginRequest.password();
        System.out.println("paso 1..");
        Authentication authentication = this.authenticate(username, password);
        System.out.println("paso 2..");
        SecurityContextHolder.getContext().setAuthentication(authentication);
        System.out.println("paso 3..");
        String accessToken = jwtUtils.createToken(authentication);
        System.out.println("paso 4..");
        return new AuthResponse(username, "User loged success", accessToken, true);
    }

    @Override
    public Authentication authenticate(String username, String password) {
        UserDetails userDetails = userDetailServiceImplS.loadUserByUsername(username);
        if (userDetails == null) {
            throw new BadCredentialsException("Invalid username or password");
        }
        if (!passwordEncoder.matches(password, userDetails.getPassword())) {
            throw new BadCredentialsException("Invalid password");
        }
        return new UsernamePasswordAuthenticationToken(username, userDetails.getPassword(), userDetails.getAuthorities());
    }

    @Override
    public AuthResponse createUser(AuthCreateUserRequest authCreateUserRequest) {
        List<String> roleRequest = authCreateUserRequest.rolerequest().roleListName();
        Set<Rol> rolSet = roleR.findByEntitiesByRole(roleRequest).stream().collect(Collectors.toSet());
        if (rolSet.isEmpty()) {
            throw new IllegalArgumentException("Invalid role");
        }
        Person person = Person.builder()
                .ci(authCreateUserRequest.ci())
                .firstName(authCreateUserRequest.firstName())
                .secondName(authCreateUserRequest.secondName())
                .name(authCreateUserRequest.name())
                .gender(authCreateUserRequest.gender())
                .status(true)
                .build();
        Long idPersona = personR.save(person);

        SystemUser user = SystemUser.builder()
                .id(idPersona)
                .username(authCreateUserRequest.username())
                .password(passwordEncoder.encode(authCreateUserRequest.password()))
                .email(authCreateUserRequest.email())
                .alias(authCreateUserRequest.alias())
                .cell(authCreateUserRequest.cell())
                .codeCell(authCreateUserRequest.codeCell())
                .dateStartVerification(authCreateUserRequest.dateStartVerification())
                .dateEndVerification(authCreateUserRequest.dateEndVerification())
                .idCity(authCreateUserRequest.idCity())
                .idPerson(person.getId())
                .isEnabled(true)
                .accountNoLocked(true)
                .accountNoExpired(true)
                .credentialNoExpired(true)
                .build();
        SystemUser savedUser = systemUserR.save(user);
        rolSet.forEach(role -> { // guardamos en la tabla intermedia el usuario y los roles
            List<Permission> permissions = systemUserR.findPermissionListByRol(Long.valueOf(role.getId()));
            roleR.saveRolePermissions(role.getId(), permissions);
            roleR.saveAll(savedUser.getId(), new ArrayList<>(rolSet));
        });

        List<Permission> permissionList = new ArrayList<>();
        for (Rol rol : rolSet) {
            permissionList.addAll(systemUserR.findPermissionListByRol(Long.valueOf(rol.getId())));
        }
        Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.addAll(rolSet
                .stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role.getName()))
                .collect(Collectors.toSet()));

        authorities.addAll(permissionList
                .stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getName()))
                .collect(Collectors.toSet()));
        Authentication authentication = new UsernamePasswordAuthenticationToken(savedUser.getUsername(), savedUser.getPassword(), authorities);
        String acccessToken = jwtUtils.createToken(authentication);
        AuthResponse authResponse = new AuthResponse(savedUser.getUsername(), "Usuario creado", acccessToken, true);
        return authResponse;
    }

    @Override
    public ResponseEntity<ApiResponse> update(SystemUser obj) {
        SystemUser isUpdated = systemUserR.update(obj);
        return customResponseBuilder.buildResponse(HttpStatus.OK.value(), "Actualizacion exitosa!!", isUpdated);
    }

    @Override
    public ResponseEntity<ApiResponse> updateChangePassword(String username, String passwd) {
        SystemUsers isUpdated = systemUserR.updateChangePass(username,passwd);  //.update(obj);
        return customResponseBuilder.buildResponse(HttpStatus.OK.value(), "Actualizacion exitosa!!", isUpdated);
    }

    @Override
    public SystemUser findSystemUserByEmail(String email) {
        SystemUser isUpdated = systemUserR.findSystemUserByEmail(email);
        return isUpdated;
    }
}
