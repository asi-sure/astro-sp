package com.congreso.backend.repository;

import com.congreso.backend.model.Permission;
import com.congreso.backend.model.Rol;
import com.congreso.backend.model.Role;
import com.congreso.backend.model.dto.RoleDto;
import jakarta.transaction.Transactional;

import java.util.List;

public interface RoleR {
//    boolean deleteById(Integer id);

    List<Rol> findByEntitiesByRole(List<String> roleNames);

//    List<Rol> findAll();

    Role getById(Long id);
    List<RoleDto> findByPerson(Long id_person);

//    Integer save(Rol obj);

    @Transactional
    boolean saveAll(Long userId, List<Rol> rolList);

    boolean saveRolePermissions(Integer roleId, List<Permission> permissions);
}
