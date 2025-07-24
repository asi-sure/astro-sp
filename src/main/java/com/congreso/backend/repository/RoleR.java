package com.congreso.backend.repository;

import com.congreso.backend.model.*;
import com.congreso.backend.model.dto.RoleDto;
import jakarta.transaction.Transactional;

import java.util.List;

public interface RoleR {
    List<Role> findAll(Boolean status);
    Long grantPersons(Rolper role);
    Boolean revokePersons(int idPerson, int idRol);
    Long save(Role role);

    Role getById(Long id);
    List<RoleDto> findByPerson(Long id_person);





//ESTOS 3 DE ABAJO SON DEL ANTIGUO SISTEMA
//    Integer save(Rol obj);
//    boolean deleteById(Integer id);
//    List<Rol> findAll();
    List<Rol> findByEntitiesByRole(List<String> roleNames);
    @Transactional
    boolean saveAll(Long userId, List<Rol> rolList);
    boolean saveRolePermissions(Integer roleId, List<Permission> permissions);
} //the end
