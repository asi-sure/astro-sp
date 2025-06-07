package com.congreso.backend.repository.Impl;

import com.congreso.backend.model.SystemUser;
import com.congreso.backend.repository.PasswordResetTokenR;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Repository
public class PasswordResetTokenImplR implements PasswordResetTokenR {
    private final JdbcTemplate db;

    @Override
    public boolean updateCodeCell(String token, LocalDateTime nowStart, LocalDateTime nowEnd, Long id) {
        String sql = "UPDATE systems_user SET code_cell = ?, date_start_verification = ?, date_end_verification = ? WHERE id = ?";
        return db.update(sql, token, nowStart, nowEnd, id) > 0;
    }

    @Override
    public SystemUser findByCodeCell(String token) {
        String sql = "SELECT * FROM systems_user WHERE code_cell = ?";
        return db.queryForObject(sql, new Object[]{token}, (rs, rowNum) -> {
            SystemUser systemUser = new SystemUser();
            systemUser.setId(rs.getLong("id"));
            systemUser.setCodeCell(rs.getString("code_cell"));
            systemUser.setDateStartVerification(rs.getTimestamp("date_start_verification").toLocalDateTime());
            systemUser.setDateEndVerification(rs.getTimestamp("date_end_verification").toLocalDateTime());
            return systemUser;
        });
    }
}
