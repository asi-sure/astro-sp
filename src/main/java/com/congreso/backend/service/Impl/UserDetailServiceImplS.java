package com.congreso.backend.service.Impl;

import com.congreso.backend.model.Permission;
import com.congreso.backend.model.Rol;
import com.congreso.backend.model.SystemUser;
import com.congreso.backend.model.SystemUsers;
import com.congreso.backend.repository.SystemUserR;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserDetailServiceImplS implements UserDetailsService {
    private final SystemUserR systemUserR;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        SystemUser user = systemUserR.findSystemUserByUsername(username);
        SystemUsers user = systemUserR.findSystemUserByUsername(username);
//        List<Rol> rolList = systemUserR.findRolListByUser(user.getId());
        List<Rol> rolList = systemUserR.findRolListByUser(user.getIdPerson());
        List<Permission> permissionList = new ArrayList<>();
        for (Rol rol : rolList) {
            permissionList.addAll(systemUserR.findPermissionListByRol(Long.valueOf(rol.getId())));
        }

        Set<GrantedAuthority> authorities = new HashSet<>();

        authorities.addAll(rolList
                .stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role.getName()))
                .collect(Collectors.toSet()));

        authorities.addAll(permissionList
                .stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getName()))
                .collect(Collectors.toSet()));

        Set<GrantedAuthority> authoritiesSet = new HashSet<>(authorities);

        // Verificar si el usuario tiene al menos un rol o permiso
        if (authorities.isEmpty()) {
            throw new IllegalStateException("El usuario no tiene roles ni permisos asignados");
        }

        // Manejar valores nulos de las propiedades booleanas
        boolean isEnabled = user.getIsEnabled() != null ? user.getIsEnabled() : true;
        boolean accountNonExpired = user.getAccountNoExpired() != null ? user.getAccountNoExpired() : true;
        boolean accountNonLocked = user.getAccountNoLocked() != null ? user.getAccountNoLocked() : true;
        boolean credentialNonExpired = user.getCredentialNoExpired() != null ? user.getCredentialNoExpired() : true;

        return new User(
                user.getUsername(),
                user.getPassword(),
                isEnabled,
                accountNonExpired,
                credentialNonExpired,
                accountNonLocked,
                authoritiesSet
        );
    }
}
