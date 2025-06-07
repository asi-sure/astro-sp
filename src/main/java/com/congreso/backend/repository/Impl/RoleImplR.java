package com.congreso.backend.repository.Impl;

import com.congreso.backend.model.Permission;
import com.congreso.backend.model.Rol;
import com.congreso.backend.model.Role;
import com.congreso.backend.model.dto.RoleDto;
import com.congreso.backend.repository.RoleR;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class RoleImplR implements RoleR {
    private final JdbcTemplate db;
    private String sql;

   @Override
    public Role getById(Long id) {
        sql = "SELECT * FROM role WHERE id_role = ?;";
        return db.queryForObject(sql, BeanPropertyRowMapper.newInstance(Role.class),id);
    }

    @Override
    public List<RoleDto> findByPerson(Long id_person) {
        sql = " SELECT ro.id_role,ro.name "
             +" from rolper r, role ro "
             +" where  (r.id_person=?)and(r.id_role=ro.id_role) "
             +" order by 1,2 ";
        return db.query(sql, BeanPropertyRowMapper.newInstance(RoleDto.class),id_person);
    }
    /*
        @Override
    public SystemUsers findSystemUserByUsername(String username) {
        sql = "SELECT su.* FROM system_users su WHERE su.username = ? AND status = true;";
        return db.queryForObject(sql, BeanPropertyRowMapper.newInstance(SystemUsers.class), username);
    }

     */

/*    @Override
    public List<Rol> findAll() {
        sql = "SELECT * FROM rol WHERE status = true;";
        return db.query(sql, BeanPropertyRowMapper.newInstance(Rol.class));
    }*/

/*    @Override
    public Integer save(Rol obj) {
        sql = "INSERT INTO rol(description,name) VALUES(?,?) RETURNING id; ";
        return db.queryForObject(sql, new Object[]{obj.getDescription(), obj.getName()}, Integer.class);
    }*/

/*    @Override
    public boolean deleteById(Integer id) {
        sql = "UPDATE rol SET status = false  WHERE id = ?";
        return db.update(sql, id) > 0;
    }*/

    @Override
    public List<Rol> findByEntitiesByRole(List<String> roleNames) {
        String roleNamesCsv = roleNames.stream().map(name -> "'" + name + "'").collect(Collectors.joining(", "));
        sql = "SELECT * FROM rol WHERE name IN (" + roleNamesCsv + ")";
        return db.query(sql, new BeanPropertyRowMapper<Rol>(Rol.class));
    }

    @Override
    @Transactional
    public boolean saveAll(Long userId, List<Rol> rolList) {
        sql = "INSERT INTO user_rol (rol_id,system_user_id) VALUES(?,?) ON CONFLICT DO NOTHING";
        int insertRows[] = db.batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                Rol rol = rolList.get(i);
                if(userId!= null && rol!=null && rol.getId()!=null ){
                    ps.setInt(1, rolList.get(i).getId());
                    ps.setLong(2, userId);
                }else{
                    ps.setNull(1, Types.INTEGER);
                    ps.setNull(2, Types.INTEGER);
                }
            }

            @Override
            public int getBatchSize() {
                return rolList.size();
            }
        });
        return insertRows.length > 0;
    }

    @Override
    public boolean saveRolePermissions(Integer roleId, List<Permission> permissions) {
        String sql = "INSERT INTO rol_permission (rol_id, permission_id) VALUES (?, ?) ON CONFLICT DO NOTHING";
        int[] insertRows = db.batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                Permission permission = permissions.get(i);
                if (roleId != null && permission != null && permission.getId() != null) {
                    ps.setInt(1, roleId);
                    ps.setLong(2, permission.getId());
                } else {
                    ps.setNull(1, Types.INTEGER);
                    ps.setNull(2, Types.INTEGER);
                }
            }

            @Override
            public int getBatchSize() {
                return permissions.size();
            }
        });
        return insertRows.length > 0;
    }
}
