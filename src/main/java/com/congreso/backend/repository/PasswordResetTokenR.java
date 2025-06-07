package com.congreso.backend.repository;

import com.congreso.backend.model.SystemUser;

import java.time.LocalDateTime;

public interface PasswordResetTokenR {
    boolean updateCodeCell(String token, LocalDateTime nowStart, LocalDateTime nowEnd, Long id);

    SystemUser findByCodeCell(String token);
}
