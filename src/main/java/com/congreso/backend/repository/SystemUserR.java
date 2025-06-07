package com.congreso.backend.repository;

import com.congreso.backend.model.Permission;
import com.congreso.backend.model.Rol;
import com.congreso.backend.model.SystemUser;
import com.congreso.backend.model.SystemUsers;

import java.util.List;

public interface SystemUserR {
    List<SystemUser> findAll();

    public List<Permission> findPermissionListByRol(Long systemUserId);

    SystemUser findById(Long id);

    SystemUser findSystemUserByEmail(String email);

    SystemUser save(SystemUser obj);

//    public SystemUser findSystemUserByUsername(String username);
    public SystemUsers findSystemUserByUsername(String username);

    public List<Rol> findRolListByUser(Long systemUserId);

    SystemUser update(SystemUser obj);
    SystemUsers updateChangePass(String username, String passwd);


}
