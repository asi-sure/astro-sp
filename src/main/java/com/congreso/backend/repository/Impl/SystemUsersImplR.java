package com.congreso.backend.repository.Impl;

import com.congreso.backend.model.SystemUsers;
import com.congreso.backend.model.dto.SystemUsersDto;
import com.congreso.backend.repository.SystemUsersR;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class SystemUsersImplR implements SystemUsersR {
    private final JdbcTemplate db;
    private String sql;
    @Override
    public Long save(SystemUsersDto user) {
        sql = "  insert into system_users(id_person, username, password, status) " +
              "  values(?,?,?,?) RETURNING id_person; ";
        return db.queryForObject(sql, new Object[]{user.getIdPerson(),user.getUsername(),user.getPassword(),true}, Long.class);
    }

    @Override
    public boolean verificarUserName(String xusername) {
        String sql="SELECT EXISTS(SELECT 1 FROM system_users WHERE username = ?)";
        Boolean existe = db.queryForObject(sql, Boolean.class, xusername);
        return existe != null && existe;
    }
}
