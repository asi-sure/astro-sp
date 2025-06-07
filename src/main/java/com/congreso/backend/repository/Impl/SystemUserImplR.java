package com.congreso.backend.repository.Impl;

import com.congreso.backend.model.Permission;
import com.congreso.backend.model.Rol;
import com.congreso.backend.model.SystemUser;
import com.congreso.backend.model.SystemUsers;
import com.congreso.backend.repository.SystemUserR;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class SystemUserImplR implements SystemUserR {
    private final JdbcTemplate db;
    private String sql;

/*    @Override
    public SystemUser findSystemUserByUsername(String username) {
        sql = "SELECT su.* FROM systems_user su WHERE su.username = ? AND status = true;";
        return db.queryForObject(sql, BeanPropertyRowMapper.newInstance(SystemUser.class), username);
    }*/
    @Override
    public SystemUsers findSystemUserByUsername(String username) {
        sql = "SELECT su.* FROM system_users su WHERE su.username = ? AND status = true;";
        return db.queryForObject(sql, BeanPropertyRowMapper.newInstance(SystemUsers.class), username);
    }
    @Override
    public List<Rol> findRolListByUser(Long systemUserId) {
        sql = "SELECT r.* FROM rol r INNER JOIN user_rol ur ON ur.rol_id = r.id AND ur.system_user_id = ? WHERE r.status = true;";
        return db.query(sql, BeanPropertyRowMapper.newInstance(Rol.class), systemUserId);
    }

    @Override
    public List<Permission> findPermissionListByRol(Long roleId) {
        sql = "SELECT p.* FROM permission p INNER JOIN rol_permission rp ON rp.permission_id =p.id  AND rp.rol_id  = ? WHERE p.status = true;";
        return db.query(sql, BeanPropertyRowMapper.newInstance(Permission.class), roleId);
    }

    @Override
    public List<SystemUser> findAll() {
        sql = "SELECT * FROM systems_user WHERE status = true;";
        return db.query(sql, BeanPropertyRowMapper.newInstance(SystemUser.class));
    }

    @Override
    public SystemUser findById(Long id) {
        sql = "SELECT * FROM systems_user WHERE id = ?;";
        return db.queryForObject(sql, BeanPropertyRowMapper.newInstance(SystemUser.class), id);
    }
    @Override
    public SystemUser findSystemUserByEmail(String email) {
        sql = "SELECT * FROM systems_user WHERE email = ?;";
        return db.queryForObject(sql, new Object[]{email}, BeanPropertyRowMapper.newInstance(SystemUser.class));
    }

    @Override
    public SystemUser save(SystemUser obj) {
        sql = "INSERT INTO systems_user (id,alias, email, username, password, cell,code_cell,date_start_verification, date_end_verification, is_enabled, account_no_expired,account_no_locked,credential_no_exipred,id_city,id_person) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) RETURNING *;";
        return db.queryForObject(sql, BeanPropertyRowMapper.newInstance(SystemUser.class), obj.getId(), obj.getAlias(), obj.getEmail(), obj.getUsername(), obj.getPassword(), obj.getCell(), obj.getCodeCell(), obj.getDateStartVerification(), obj.getDateEndVerification(), obj.getIsEnabled(), obj.getAccountNoExpired(), obj.getAccountNoLocked(), obj.getCredentialNoExpired(), obj.getIdCity(), obj.getIdPerson());
    }

    @Override
    public SystemUser update(SystemUser obj) {
        sql = "UPDATE systems_user SET alias=?, email=?, username=?, password=?, cell=?, code_cell=?, date_start_verification=?, date_end_verification=?, is_enabled=?, account_no_expired=?, account_no_locked=?, credential_no_exipred=?, id_city=?, id_person=? WHERE id=? RETURNING *;";
        return db.queryForObject(sql, BeanPropertyRowMapper.newInstance(SystemUser.class), obj.getAlias(), obj.getEmail(), obj.getUsername(), obj.getPassword(), obj.getCell(), obj.getCodeCell(), obj.getDateStartVerification(), obj.getDateEndVerification(), obj.getIsEnabled(), obj.getAccountNoExpired(), obj.getAccountNoLocked(), obj.getCredentialNoExpired(), obj.getIdCity(), obj.getIdPerson(), obj.getId());
    }

    @Override
    public SystemUsers updateChangePass(String username, String passwd) {
        sql = "UPDATE system_users SET password=? WHERE username=? RETURNING *;";
        return db.queryForObject(sql, BeanPropertyRowMapper.newInstance(SystemUsers.class), passwd, username);
    }
}
